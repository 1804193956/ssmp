package com.entor.service.impl;

import com.entor.entity.ClassesStudy;
import com.entor.entity.vo.ClassesStudyVO;
import com.entor.mapper.ClassesStudyMapper;
import com.entor.service.IClassesStudyService;
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
public class ClassesStudyServiceImpl extends ServiceImpl<ClassesStudyMapper, ClassesStudy> implements IClassesStudyService {
	@Autowired
	private ClassesStudyMapper classesStudyMapper;
	@Override
	public List<ClassesStudyVO> queryByPage(Map<String, Object> map) {
		return classesStudyMapper.queryByPage(map);
	}

}
