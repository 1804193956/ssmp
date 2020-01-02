package com.entor.service.impl;

import com.entor.entity.Major;
import com.entor.mapper.MajorMapper;
import com.entor.service.IMajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {
	
	@Autowired
	private MajorMapper majorMapper;

	@Override
	public String queryIdByName(String name) {
		return majorMapper.queryIdByName(name);
	}

}
