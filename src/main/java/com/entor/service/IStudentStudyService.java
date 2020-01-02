package com.entor.service;

import com.entor.entity.StudentStudy;
import com.entor.entity.vo.StudentStudyVO;

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
public interface IStudentStudyService extends IService<StudentStudy> {
	public List<StudentStudyVO> queryByPage(Map<String, Object> map);
}
