package com.entor.mapper;

import com.entor.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
	public String queryIdByName(String name);
}
