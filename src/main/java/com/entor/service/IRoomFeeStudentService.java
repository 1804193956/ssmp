package com.entor.service;

import com.entor.entity.RoomFeeStudent;
import com.entor.entity.vo.RoomFeeStudentVO;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface IRoomFeeStudentService extends IService<RoomFeeStudent> {
	public List<RoomFeeStudentVO> queryByPage(Map<String, Object> map);
}
