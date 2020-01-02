package com.entor.service.impl;

import com.entor.entity.StudentListen;
import com.entor.entity.vo.StudentListenVO;
import com.entor.mapper.StudentListenMapper;
import com.entor.service.IStudentListenService;
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
 * @since 2019-12-16
 */
@Service
public class StudentListenServiceImpl extends ServiceImpl<StudentListenMapper, StudentListen> implements IStudentListenService {

	@Autowired
	private StudentListenMapper studentListenMapper;
	@Override
	public List<StudentListenVO> queryByPage(Map<String, Object> map) {
		return studentListenMapper.queryByPage(map);
	}

}
