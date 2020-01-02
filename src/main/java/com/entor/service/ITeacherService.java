package com.entor.service;

import com.entor.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface ITeacherService extends IService<Teacher> {
	public String queryIdByName(String name);
}
