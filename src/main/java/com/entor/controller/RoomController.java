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
import com.entor.entity.Room;
import com.entor.entity.Result;
import com.entor.service.IRoomService;
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
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private IRoomService roomService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(
			@RequestParam(value = "rows", required = false, defaultValue = "20") String rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page, Room room) {
		// 创建查询条件对象
		QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
		if (!StringUtils.isEmpty(room.getRoomName())) {
			queryWrapper.like("name", room.getRoomName());
		}
		// 根据条件获取总记录数
		int total = roomService.count(queryWrapper);

		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		// 拼接分页sql
		queryWrapper.last("limit " + (currentPage - 1) * pageSize + "," + pageSize);
		List<Room> list = roomService.list(queryWrapper);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@RequestMapping("/add")
	public Result add(Room room) {
		roomService.save(room);
		return new Result(0, "数据添加成功");
	}

	@RequestMapping("/update")
	public Result update(Room room) {
		roomService.updateById(room);
		return new Result(0, "数据修改成功");
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		roomService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功");
	}

	@RequestMapping("/queryAll")
	public List<Room> queryAll() {
		return roomService.list();
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
		EasyExcelUtil.writeExcelWithModel(out, null, Room.class,ExcelTypeEnum.XLS);
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
		EasyExcelUtil.writeExcelWithModel(out, roomService.list(), Room.class,ExcelTypeEnum.XLS);
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
	public ResponseEntity<byte[]> downloadPart(String fileName, HttpServletRequest request,String ids) throws IOException {
		QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
		queryWrapper.in("id", Arrays.asList(ids.split(",")));
		// 文件格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
		int r = (int) (Math.random() * 1000);
		fileName = sdf.format(new Date()) + r + ".xls";
		// 获取服务器文件存放路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 下载文件对象
		File file = new File(path, fileName);
		OutputStream out  = new FileOutputStream(file);
		EasyExcelUtil.writeExcelWithModel(out, roomService.list(queryWrapper), Room.class,ExcelTypeEnum.XLS);
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
		roomService.saveBatch(EasyExcelUtil.readExcelWithModel(is, Room.class, ExcelTypeEnum.XLS), 300);
		return new Result(0, "数据添加成功");
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
