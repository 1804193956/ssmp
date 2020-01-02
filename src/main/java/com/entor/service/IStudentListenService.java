package com.entor.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entor.entity.StudentListen;
import com.entor.entity.vo.StudentListenVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Willis
 * @since 2019-12-16
 */
public interface IStudentListenService extends IService<StudentListen> {

	public List<StudentListenVO> queryByPage(Map<String, Object> map);
}
