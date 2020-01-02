package com.entor.service;

import com.entor.entity.Fee;
import com.entor.entity.vo.FeeVO;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
public interface IFeeService extends IService<Fee> {
	public List<FeeVO> queryByPage(Map<String, Object> map);
}
