package com.entor.entity;

import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("crm_room_fee_student")
public class RoomFeeStudent extends BaseRowModel implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
    /**
     * 主键编号
     */
    @TableId(type=IdType.ASSIGN_UUID)
    private String id;

    /**
     * 房间编号
     */
    private String roomId;

    /**
     * 学生编号
     */
    private String studentId;

    /**
     * 用水费
     */
    private Float useWater;

    /**
     * 用电费
     */
    private Float useElectricity;

    /**
     * 物业费
     */
    private Float roomFee;

    /**
     * 总费用
     */
    private Float totalFee;

    /**
     * 费用产生日期
     */
    private Date createDate;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RoomFeeStudent{" +
        "id=" + id +
        ", roomId=" + roomId +
        ", studentId=" + studentId +
        ", useWater=" + useWater +
        ", useElectricity=" + useElectricity +
        ", roomFee=" + roomFee +
        ", totalFee=" + totalFee +
        ", createDate=" + createDate +
        ", createTime=" + createTime +
        "}";
    }
}
