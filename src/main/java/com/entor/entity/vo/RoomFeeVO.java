package com.entor.entity.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RoomFeeVO extends BaseRowModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9088777846071487396L;
	/**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
	private String id;//主键编号
	private String roomName;//房间编号
	private Float useWater;//用水费
	private Float useElectricity;//用电费
	private Float roomFee;//物业费
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date createDate;//费用产生日期
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Timestamp createTime;//创建时间
	
	
	@Override
	public String toString() {
		return "RoomFeeView [id=" + id + ", roomName=" + roomName + ", useWater=" + useWater + ", useElectricity="
				+ useElectricity + ", roomFee=" + roomFee + ", createDate=" + createDate + ", createTime=" + createTime
				+ "]";
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getUseWater() {
		return useWater;
	}
	public void setUseWater(Float useWater) {
		this.useWater = useWater;
	}
	public Float getUseElectricity() {
		return useElectricity;
	}
	public void setUseElectricity(Float useElectricity) {
		this.useElectricity = useElectricity;
	}
	public Float getRoomFee() {
		return roomFee;
	}
	public void setRoomFee(Float roomFee) {
		this.roomFee = roomFee;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}	
