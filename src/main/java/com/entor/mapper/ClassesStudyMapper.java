package com.entor.mapper;

import com.entor.entity.ClassesStudy;
import com.entor.entity.vo.ClassesStudyVO;

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
public interface ClassesStudyMapper extends BaseMapper<ClassesStudy> {
	public List<ClassesStudyVO> queryByPage(Map<String, Object> map);
}
