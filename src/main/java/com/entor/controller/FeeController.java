package com.entor.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entor.entity.Result;
import com.entor.entity.Fee;
import com.entor.entity.vo.FeeVO;
import com.entor.service.IFeeService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@RestController
@RequestMapping("/fee")
public class FeeController {
	@Autowired
	private IFeeService feeService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(
			@RequestParam(value = "rows", required = false, defaultValue = "20") String rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page, Fee fee) {
		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", (currentPage - 1) * pageSize);
		paramMap.put("pageSize", pageSize);
//		paramMap.put("name", fee.get));
		List<FeeVO> list = feeService.queryByPage(paramMap);
		// 创建查询条件对象
		QueryWrapper<Fee> queryWrapper = new QueryWrapper<>();
//		if (!StringUtils.isEmpty(fee.getName())) {
//			queryWrapper.like("name", fee.getName());
//		}
		int total = feeService.count(queryWrapper);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@RequestMapping("/add")
	public Result add(Fee fee) {
		feeService.save(fee);
		return new Result(0, "数据添加成功");
	}

	@RequestMapping("/update")
	public Result update(Fee fee) {
		feeService.updateById(fee);
		return new Result(0, "数据修改成功");
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		feeService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功");
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
