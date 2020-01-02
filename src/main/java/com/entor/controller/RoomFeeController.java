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
import com.entor.entity.RoomFee;
import com.entor.entity.vo.RoomFeeVO;
import com.entor.service.IRoomFeeService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@RestController
@RequestMapping("/roomFee")
public class RoomFeeController {
	@Autowired
	private IRoomFeeService roomFeeService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(
			@RequestParam(value = "rows", required = false, defaultValue = "20") String rows,
			@RequestParam(value = "page", required = false, defaultValue = "1") String page, RoomFee roomFee) {
		int currentPage = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", (currentPage - 1) * pageSize);
		paramMap.put("pageSize", pageSize);
//		paramMap.put("name", roomFee.get));
		List<RoomFeeVO> list = roomFeeService.queryByPage(paramMap);
		// 创建查询条件对象
		QueryWrapper<RoomFee> queryWrapper = new QueryWrapper<>();
//		if (!StringUtils.isEmpty(roomFee.getName())) {
//			queryWrapper.like("name", roomFee.getName());
//		}
		int total = roomFeeService.count(queryWrapper);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	@RequestMapping("/add")
	public Result add(RoomFee roomFee) {
		roomFeeService.save(roomFee);
		return new Result(0, "数据添加成功");
	}

	@RequestMapping("/update")
	public Result update(RoomFee roomFee) {
		roomFeeService.updateById(roomFee);
		return new Result(0, "数据修改成功");
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		roomFeeService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功");
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
