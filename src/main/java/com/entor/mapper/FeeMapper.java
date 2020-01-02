package com.entor.mapper;

import com.entor.entity.Fee;
import com.entor.entity.vo.FeeVO;

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
public interface FeeMapper extends BaseMapper<Fee> {
	public List<FeeVO> queryByPage(Map<String, Object> map);
}
