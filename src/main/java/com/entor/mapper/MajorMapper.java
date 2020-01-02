package com.entor.mapper;

import com.entor.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface MajorMapper extends BaseMapper<Major> {
	public String queryIdByName(String name);
}
