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
 * @since 2019-12-16
 */
@TableName("crm_student_listen")
public class StudentListen extends BaseRowModel implements Serializable {

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
    @TableId(type=IdType.ASSIGN_UUID)
    private String id;

    /**
     * 学生姓名
     */
    @ExcelProperty(value="试听学生姓名",index=1)
    private String name;

    /**
     * 学生性别
     */
    @ExcelProperty(value="学生性别",index=2)
    private Integer sex;

    /**
     * 学生电话
     */
    @ExcelProperty(value="学生电话",index=3)
    private String phone;

    /**
     * 学生地址
     */
    @ExcelProperty(value="学生地址",index=4)
    private String address;

    /**
     * 试听日期
     */
    @ExcelProperty(value="试听日期",index=5,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date listenDate;

    /**
     * 试听专业
     */
    @ExcelProperty(value="试听专业",index=6)
    private String majorId;

    /**
     * 创建时间
     */
    @ExcelProperty(value="创建时间",index=7)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getListenDate() {
        return listenDate;
    }

    public void setListenDate(Date listenDate) {
        this.listenDate = listenDate;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StudentListen{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", phone=" + phone +
        ", address=" + address +
        ", listenDate=" + listenDate +
        ", majorId=" + majorId +
        ", createTime=" + createTime +
        "}";
    }
}
