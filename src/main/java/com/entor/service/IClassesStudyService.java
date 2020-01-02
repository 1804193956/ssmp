package com.entor.service;

import com.entor.entity.ClassesStudy;
import com.entor.entity.vo.ClassesStudyVO;

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
public interface IClassesStudyService extends IService<ClassesStudy> {
	public List<ClassesStudyVO> queryByPage(Map<String, Object> map);
}
