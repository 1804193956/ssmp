package com.entor.service.impl;

import com.entor.entity.ClassesListen;
import com.entor.entity.vo.ClassesListenVO;
import com.entor.mapper.ClassesListenMapper;
import com.entor.service.IClassesListenService;
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
public class ClassesListenServiceImpl extends ServiceImpl<ClassesListenMapper, ClassesListen> implements IClassesListenService {

	@Autowired
	private ClassesListenMapper classesListenMapper;
	@Override
	public List<ClassesListenVO> queryByPage(Map<String, Object> map) {
		return classesListenMapper.queryByPage(map);
	}
	@Override
	public List<ClassesListenVO> queryAll() {
		return classesListenMapper.queryAll();
	}

}
