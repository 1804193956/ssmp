package com.entor.service.impl;

import com.entor.entity.RoomFee;
import com.entor.entity.vo.RoomFeeVO;
import com.entor.mapper.RoomFeeMapper;
import com.entor.service.IRoomFeeService;
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
public class RoomFeeServiceImpl extends ServiceImpl<RoomFeeMapper, RoomFee> implements IRoomFeeService {
	@Autowired
	private RoomFeeMapper roomFeeMapper;
	@Override
	public List<RoomFeeVO> queryByPage(Map<String, Object> map) {
		return roomFeeMapper.queryByPage(map);
	}

}
