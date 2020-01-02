package com.entor.entity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentListenVO extends BaseRowModel implements Serializable{

	private static final long serialVersionUID = 7132970235791414418L;

	/**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
	/**
     * 主键编号
     */
    @ExcelProperty(value="编号",index=0)
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
    private String majorName;

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

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
