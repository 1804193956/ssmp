package com.entor.service;

import com.entor.entity.ClassesListen;
import com.entor.entity.vo.ClassesListenVO;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface IClassesListenService extends IService<ClassesListen> {
	public List<ClassesListenVO> queryByPage(Map<String, Object> map);
	
	public List<ClassesListenVO> queryAll();
}
