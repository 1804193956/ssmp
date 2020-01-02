package com.entor.mapper;

import com.entor.entity.RoomFeeStudent;
import com.entor.entity.vo.RoomFeeStudentVO;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface RoomFeeStudentMapper extends BaseMapper<RoomFeeStudent> {
	public List<RoomFeeStudentVO> queryByPage(Map<String, Object> map);
}
