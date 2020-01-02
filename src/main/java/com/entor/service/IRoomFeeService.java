package com.entor.service;

import com.entor.entity.RoomFee;
import com.entor.entity.vo.RoomFeeVO;

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
public interface IRoomFeeService extends IService<RoomFee> {
	public List<RoomFeeVO> queryByPage(Map<String, Object> map);
}
