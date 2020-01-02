package com.entor.mapper;

import com.entor.entity.RoomFee;
import com.entor.entity.vo.RoomFeeVO;

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
public interface RoomFeeMapper extends BaseMapper<RoomFee> {
	public List<RoomFeeVO> queryByPage(Map<String, Object> map);
}
