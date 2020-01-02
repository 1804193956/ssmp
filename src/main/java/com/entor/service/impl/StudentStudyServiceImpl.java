package com.entor.service.impl;

import com.entor.entity.StudentStudy;
import com.entor.entity.vo.StudentStudyVO;
import com.entor.mapper.StudentStudyMapper;
import com.entor.service.IStudentStudyService;
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
public class StudentStudyServiceImpl extends ServiceImpl<StudentStudyMapper, StudentStudy> implements IStudentStudyService {

	@Autowired
	private StudentStudyMapper studentStudyMapper;
	@Override
	public List<StudentStudyVO> queryByPage(Map<String, Object> map) {
		return studentStudyMapper.queryByPage(map);
	}

}
