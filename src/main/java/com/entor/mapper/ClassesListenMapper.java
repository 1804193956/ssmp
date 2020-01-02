package com.entor.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entor.entity.ClassesListen;
import com.entor.entity.vo.ClassesListenVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface ClassesListenMapper extends BaseMapper<ClassesListen> {
	public List<ClassesListenVO> queryByPage(Map<String, Object> map);
	
	public List<ClassesListenVO> queryAll();
}
