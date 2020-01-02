package com.entor.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entor.entity.Result;
import com.entor.entity.StudentStudy;
import com.entor.entity.vo.StudentStudyVO;
import com.entor.service.IMajorService;
import com.entor.service.IStudentStudyService;
import com.entor.util.ExeclIO;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@RestController
@RequestMapping("/studentStudy")
public class StudentStudyController {
	@Autowired
	private IStudentStudyService studentStudyService;
	private List<StudentStudyVO> array = null;
	@Autowired
	private IMajorService majorService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(
			@RequestParam(value = "rows", required = false, defaultValue = "20") String rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			StudentStudy studentStudy) {
		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", studentStudy.getName());
		if(!StringUtils.isEmpty(studentStudy.getSex())) {
			paramMap.put("sex", studentStudy.getSex().toString());
		}
		array = studentStudyService.queryByPage(paramMap);
		paramMap.put("start", (currentPage - 1) * pageSize);
		paramMap.put("pageSize", pageSize);
		List<StudentStudyVO> list = studentStudyService.queryByPage(paramMap);
		// 创建查询条件对象
		QueryWrapper<StudentStudy> queryWrapper = new QueryWrapper<>();
		if (!StringUtils.isEmpty(studentStudy.getName())) {
			queryWrapper.like("name", studentStudy.getName());
		}
		int total = studentStudyService.count(queryWrapper);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@RequestMapping("/add")
	public Result add(StudentStudy studentStudy) {
		studentStudyService.save(studentStudy);
		return new Result(0, "数据添加成功");
	}

	@RequestMapping("/update")
	public Result update(StudentStudy studentStudy) {
		studentStudyService.updateById(studentStudy);
		return new Result(0, "数据修改成功");
	}
	
	@RequestMapping("/queryAll")
	public List<StudentStudy> queryAll(String q) {
		QueryWrapper<StudentStudy> queryWrapper = new QueryWrapper<>();
		if(!StringUtils.isEmpty(q)) {
			queryWrapper.like("name", q);
		}
		return studentStudyService.list(queryWrapper);
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		studentStudyService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功");
	}

	/*
	 * 下载模板
	 */
	@RequestMapping("/downloadMode")
	public ResponseEntity<byte[]> downloadMode(String fileName, HttpServletRequest request) throws IOException {
		return ExeclIO.downloadExcel(request, StudentStudyVO.class, null,fileName);
	}

	/*
	 * 下载全部
	 */
	@RequestMapping("/downloadAll")
	public ResponseEntity<byte[]> downloadAll(String fileName, HttpServletRequest request) throws IOException {
		return ExeclIO.downloadExcel(request, StudentStudyVO.class, array,null);
	}
	/*
	 * 下载部分
	 */
	@RequestMapping("/downloadPart")
	public ResponseEntity<byte[]> downloadPart(String fileName, HttpServletRequest request) throws IOException {
		return ExeclIO.downloadExcel(request, StudentStudyVO.class, array,null);
	}

	/*
	 * 批量添加(导入)
	 */
	@RequestMapping("/addMore")
	@ResponseBody
	public Result addMore(MultipartFile excel, HttpServletRequest request) throws IOException {
		List<StudentStudy> list = ExeclIO.readExcel(excel, StudentStudy.class, request);
		for (StudentStudy studentStudy : list) {
			studentStudy.setMajorId(majorService.queryIdByName(studentStudy.getMajorId()));
		}
		studentStudyService.saveBatch(list, 300);
		return new Result(0, "数据添加成功");
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
