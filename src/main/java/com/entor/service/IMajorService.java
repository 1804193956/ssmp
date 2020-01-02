package com.entor.service;

import com.entor.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface IMajorService extends IService<Major> {
	public String queryIdByName(String name);
}
