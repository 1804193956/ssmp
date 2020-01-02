package com.entor.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entor.entity.StudentListen;
import com.entor.entity.vo.StudentListenVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Willis
 * @since 2019-12-16
 */
public interface StudentListenMapper extends BaseMapper<StudentListen> {

	public List<StudentListenVO> queryByPage(Map<String, Object> map);
}
