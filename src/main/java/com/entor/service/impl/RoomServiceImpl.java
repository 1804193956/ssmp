package com.entor.service.impl;

import com.entor.entity.Room;
import com.entor.mapper.RoomMapper;
import com.entor.service.IRoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService {

	
	@Autowired
	private RoomMapper roomMapper;
	@Override
	public String queryIdByName(String name) {
		return roomMapper.queryIdByName(name);
	}

}
