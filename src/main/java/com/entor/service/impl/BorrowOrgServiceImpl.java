package com.entor.service.impl;

import com.entor.entity.BorrowOrg;
import com.entor.mapper.BorrowOrgMapper;
import com.entor.service.IBorrowOrgService;
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
public class BorrowOrgServiceImpl extends ServiceImpl<BorrowOrgMapper, BorrowOrg> implements IBorrowOrgService {
	
	
	@Autowired
	private BorrowOrgMapper borrowOrgMapper;

	@Override
	public String queryIdByName(String name) {
		return borrowOrgMapper.queryIdByName(name);
	}

}
