package com.entor.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Willis
 * @since 2019-12-17
 */
@TableName("crm_room")
public class Room extends BaseRowModel implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
    /**
     * 主键编号
     */
    @ExcelProperty(value="编号",index=0)
    @TableId(type=IdType.ASSIGN_UUID,value="room_id")
    private String roomId;

    /**
     * 房间名称，格式：xx栋xx单元xxx号
     */
    @ExcelProperty(value="房间名称，格式：xx栋xx单元xxx号",index=1)
    private String roomName;

    /**
     * 详细地址，格式：xxx路xxx号xxx小区xx栋xx单元xxx号
     */
    @ExcelProperty(value="详细地址",index=2)
    private String roomAddress;

    /**
     * 房间能住总人数
     */
    @ExcelProperty(value="房间能住总人数",index=3)
    private Integer roomTotalSize;

    /**
     * 空余床位
     */
    @ExcelProperty(value="空余床位",index=4)
    private Integer roomEmptySize;

    /**
     * 房间住宿人性别
     */
    @ExcelProperty(value="房间住宿人性别",index=5)
    private Integer roomPersonSex;

    /**
     * 房间每月住宿费
     */
    @ExcelProperty(value="房间每月住宿费",index=6)
    private Integer roomMoney;

    /**
     * 房间押金
     */
    @ExcelProperty(value="房间押金",index=7)
    private Integer roomDeposit;

    /**
     * 房东姓名
     */
    @ExcelProperty(value="房东姓名",index=8)
    private String roomManager;

    /**
     * 房东电话
     */
    @ExcelProperty(value="房东电话",index=9)
    private String roomManagerPhone;

    /**
     * 创建时间
     */
    @ExcelProperty(value="创建时间",index=11,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public Integer getRoomTotalSize() {
        return roomTotalSize;
    }

    public void setRoomTotalSize(Integer roomTotalSize) {
        this.roomTotalSize = roomTotalSize;
    }

    public Integer getRoomEmptySize() {
        return roomEmptySize;
    }

    public void setRoomEmptySize(Integer roomEmptySize) {
        this.roomEmptySize = roomEmptySize;
    }

    public Integer getRoomPersonSex() {
        return roomPersonSex;
    }

    public void setRoomPersonSex(Integer roomPersonSex) {
        this.roomPersonSex = roomPersonSex;
    }

    public Integer getRoomMoney() {
        return roomMoney;
    }

    public void setRoomMoney(Integer roomMoney) {
        this.roomMoney = roomMoney;
    }

    public Integer getRoomDeposit() {
        return roomDeposit;
    }

    public void setRoomDeposit(Integer roomDeposit) {
        this.roomDeposit = roomDeposit;
    }

    public String getRoomManager() {
        return roomManager;
    }

    public void setRoomManager(String roomManager) {
        this.roomManager = roomManager;
    }

    public String getRoomManagerPhone() {
        return roomManagerPhone;
    }

    public void setRoomManagerPhone(String roomManagerPhone) {
        this.roomManagerPhone = roomManagerPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Room{" +
        "roomId=" + roomId +
        ", roomName=" + roomName +
        ", roomAddress=" + roomAddress +
        ", roomTotalSize=" + roomTotalSize +
        ", roomEmptySize=" + roomEmptySize +
        ", roomPersonSex=" + roomPersonSex +
        ", roomMoney=" + roomMoney +
        ", roomDeposit=" + roomDeposit +
        ", roomManager=" + roomManager +
        ", roomManagerPhone=" + roomManagerPhone +
        ", createTime=" + createTime +
        "}";
    }
}
