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
import com.entor.entity.BorrowOrg;
import com.entor.entity.Result;
import com.entor.service.IBorrowOrgService;
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
@RequestMapping("/borrowOrg")
public class BorrowOrgController {

	@Autowired
	private IBorrowOrgService borrowOrgService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(
			@RequestParam(value = "rows", required = false, defaultValue = "20") String rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page, BorrowOrg borrowOrg) {
		// 创建查询条件对象
		QueryWrapper<BorrowOrg> queryWrapper = new QueryWrapper<>();
		if (!StringUtils.isEmpty(borrowOrg.getName())) {
			queryWrapper.like("name", borrowOrg.getName());
		}
		// 根据条件获取总记录数
		int total = borrowOrgService.count(queryWrapper);

		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		// 拼接分页sql
		queryWrapper.last("limit " + (currentPage - 1) * pageSize + "," + pageSize);
		List<BorrowOrg> list = borrowOrgService.list(queryWrapper);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@RequestMapping("/add")
	public Result add(BorrowOrg borrowOrg) {
		borrowOrgService.save(borrowOrg);
		return new Result(0, "数据添加成功");
	}

	@RequestMapping("/update")
	public Result update(BorrowOrg borrowOrg) {
		borrowOrgService.updateById(borrowOrg);
		return new Result(0, "数据修改成功");
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		borrowOrgService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功");
	}

	@RequestMapping("/queryAll")
	public List<BorrowOrg> queryAll() {
		return borrowOrgService.list();
	}

	/*
	 * 下载模板
	 */
	@RequestMapping("/downloadMode")
	public ResponseEntity<byte[]> downloadMode(HttpServletRequest request) throws IOException {
		return ExeclIO.downloadExcel(request, BorrowOrg.class, null,"分期机构模板.xls");
	}

	/*
	 * 下载全部
	 */
	@RequestMapping("/downloadAll")
	public ResponseEntity<byte[]> downloadAll(HttpServletRequest request) throws IOException {
		return ExeclIO.downloadExcel(request, BorrowOrg.class, borrowOrgService.list(),null);
	}
	/*
	 * 下载部分
	 */
	@RequestMapping("/downloadPart")
	public ResponseEntity<byte[]> downloadPart(HttpServletRequest request,String ids) throws IOException {
		QueryWrapper<BorrowOrg> queryWrapper = new QueryWrapper<>();
		queryWrapper.in("id", Arrays.asList(ids.split(",")));
		return ExeclIO.downloadExcel(request, BorrowOrg.class, borrowOrgService.list(queryWrapper),null);
	}

	/*
	 * 批量添加(导入)
	 */
	@RequestMapping("/addMore")
	@ResponseBody
	public Result addMore(MultipartFile excel, HttpServletRequest request) throws IOException {
		borrowOrgService.saveBatch(ExeclIO.readExcel(excel, BorrowOrg.class, request), 300);
		return new Result(0, "数据添加成功");
	}
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
