package com.entor.service.impl;

import com.entor.entity.RoomFeeStudent;
import com.entor.entity.vo.RoomFeeStudentVO;
import com.entor.mapper.RoomFeeStudentMapper;
import com.entor.service.IRoomFeeStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@Service
public class RoomFeeStudentServiceImpl extends ServiceImpl<RoomFeeStudentMapper, RoomFeeStudent> implements IRoomFeeStudentService {

	@Autowired
	private RoomFeeStudentMapper roomFeeStudentMapper;
	@Override
	public List<RoomFeeStudentVO> queryByPage(Map<String, Object> map) {
		return roomFeeStudentMapper.queryByPage(map);
	}

}
