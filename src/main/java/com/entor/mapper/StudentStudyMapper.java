package com.entor.mapper;

import com.entor.entity.StudentStudy;
import com.entor.entity.vo.StudentStudyVO;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface StudentStudyMapper extends BaseMapper<StudentStudy> {
	public List<StudentStudyVO> queryByPage(Map<String, Object> map);
}
