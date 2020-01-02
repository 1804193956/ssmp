package com.entor.service.impl;

import com.entor.entity.Fee;
import com.entor.entity.vo.FeeVO;
import com.entor.mapper.FeeMapper;
import com.entor.service.IFeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

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
public class FeeServiceImpl extends ServiceImpl<FeeMapper, Fee> implements IFeeService {
	@Autowired
	private FeeMapper feeMapper;
	@Override
	public List<FeeVO> queryByPage(Map<String, Object> map) {
		return feeMapper.queryByPage(map);
	}

}
