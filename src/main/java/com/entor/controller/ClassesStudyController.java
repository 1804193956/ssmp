package com.entor.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entor.entity.ClassesStudy;
import com.entor.entity.Result;
import com.entor.entity.vo.ClassesStudyVO;
import com.entor.service.IClassesStudyService;
import com.entor.service.IMajorService;
import com.entor.service.ITeacherService;
import com.entor.util.EasyExcelUtil;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@RestController
@RequestMapping("/classesStudy")
public class ClassesStudyController {
	@Autowired
	private IClassesStudyService classesStudyService;
	private List<ClassesStudyVO> array = null;
	@Autowired
	private IMajorService majorService;
	@Autowired
	private ITeacherService teacherService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(
			@RequestParam(value = "rows", required = false, defaultValue = "20") String rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			ClassesStudy classesStudy) {
		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", classesStudy.getClassesName());
		array = classesStudyService.queryByPage(paramMap);
		paramMap.put("start", (currentPage - 1) * pageSize);
		paramMap.put("pageSize", pageSize);
		List<ClassesStudyVO> list = classesStudyService.queryByPage(paramMap);
		// 创建查询条件对象
		QueryWrapper<ClassesStudy> queryWrapper = new QueryWrapper<>();
		if (!StringUtils.isEmpty(classesStudy.getClassesName())) {
			queryWrapper.like("name", classesStudy.getClassesName());
		}
		int total = classesStudyService.count(queryWrapper);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@RequestMapping("/add")
	public Result add(ClassesStudy classesStudy) {
		classesStudyService.save(classesStudy);
		return new Result(0, "数据添加成功");
	}

	@RequestMapping("/update")
	public Result update(ClassesStudy classesStudy) {
		classesStudyService.updateById(classesStudy);
		return new Result(0, "数据修改成功");
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		classesStudyService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功");
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	/*
	 * 下载模板
	 */
	@RequestMapping("/downloadMode")
	public ResponseEntity<byte[]> downloadMode(String fileName, HttpServletRequest request) throws IOException {
		// 获取服务器文件存放路径
		String path = request.getServletContext().getRealPath("/mode/");
		// 下载文件对象
		File file = new File(path, fileName);
		OutputStream out  = new FileOutputStream(file);
		EasyExcelUtil.writeExcelWithModel(out, null, ClassesStudy.class,ExcelTypeEnum.XLS);
		// 把文件放到字节数组中(缺点是不能下载大的文件,因为字节存放在内存中)
		byte[] b = FileUtils.readFileToByteArray(file);
		// 设置头部信息
		HttpHeaders headers = new HttpHeaders();
		// 设置下载框和解决中文乱码问题
		headers.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "utf-8"));
		// 设置文件类型
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}

	/*
	 * 下载全部
	 */
	@RequestMapping("/downloadAll")
	public ResponseEntity<byte[]> downloadAll(String fileName, HttpServletRequest request) throws IOException {
		// 文件格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
		int r = (int) (Math.random() * 1000);
		fileName = sdf.format(new Date()) + r + ".xls";
		// 获取服务器文件存放路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 下载文件对象
		File file = new File(path, fileName);
		OutputStream out  = new FileOutputStream(file);
		EasyExcelUtil.writeExcelWithModel(out, classesStudyService.queryByPage(null), ClassesStudyVO.class,ExcelTypeEnum.XLS);
		// 把文件放到字节数组中(缺点是不能下载大的文件,因为字节存放在内存中)
		byte[] b = FileUtils.readFileToByteArray(file);
		// 设置头部信息
		HttpHeaders headers = new HttpHeaders();
		// 设置下载框和解决中文乱码问题
		headers.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "utf-8"));
		// 设置文件类型
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}
	/*
	 * 下载部分
	 */
	@RequestMapping("/downloadPart")
	public ResponseEntity<byte[]> downloadPart(String fileName, HttpServletRequest request) throws IOException {
		// 文件格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
		int r = (int) (Math.random() * 1000);
		fileName = sdf.format(new Date()) + r + ".xls";
		// 获取服务器文件存放路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 下载文件对象
		File file = new File(path, fileName);
		OutputStream out  = new FileOutputStream(file);
		EasyExcelUtil.writeExcelWithModel(out, array, ClassesStudyVO.class,ExcelTypeEnum.XLS);
		// 把文件放到字节数组中(缺点是不能下载大的文件,因为字节存放在内存中)
		byte[] b = FileUtils.readFileToByteArray(file);
		// 设置头部信息
		HttpHeaders headers = new HttpHeaders();
		// 设置下载框和解决中文乱码问题
		headers.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "utf-8"));
		// 设置文件类型
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}

	/*
	 * 批量添加(导入)
	 */
	@RequestMapping("/addMore")
	@ResponseBody
	public Result addMore(MultipartFile excel, HttpServletRequest request) throws IOException {
		String path = request.getServletContext().getRealPath("/upload/");
		String fileName = excel.getOriginalFilename();
		File file = new File(path, fileName);
		System.out.println(file.getPath());
		excel.transferTo(file);
		InputStream is = new FileInputStream(file);
		List<ClassesStudy> list = EasyExcelUtil.readExcelWithModel(is, ClassesStudy.class, ExcelTypeEnum.XLS);
		for (ClassesStudy classesStudy : list) {
			classesStudy.setMajorId(majorService.queryIdByName(classesStudy.getMajorId()));
			classesStudy.setManagerId(teacherService.queryIdByName(classesStudy.getManagerId()));
			classesStudy.setTeacherId(teacherService.queryIdByName(classesStudy.getTeacherId()));
		}
		classesStudyService.saveBatch(list, 300);
		return new Result(0, "数据添加成功");
	}
}
