package com.entor.service.impl;

import com.entor.entity.Teacher;
import com.entor.mapper.TeacherMapper;
import com.entor.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

	
	@Autowired
	private TeacherMapper teacherMapper;
	@Override
	public String queryIdByName(String name) {
		return teacherMapper.queryIdByName(name);
	}

}
