package com.entor.mapper;

import com.entor.entity.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface RoomMapper extends BaseMapper<Room> {
	public String queryIdByName(String name);
}
