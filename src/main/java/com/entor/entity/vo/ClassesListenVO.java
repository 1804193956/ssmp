package com.entor.entity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClassesListenVO  extends BaseRowModel implements Serializable{
	private static final long serialVersionUID = -4453128361781657295L;

	/**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
	/**
     * 主键编号
     */
    @ExcelProperty(value="编号",index=0)
	@TableId(type=IdType.ASSIGN_UUID,value="classes_id")
    private String classesId;

    /**
     * 班级名称（格式：yyyy-MMxxx专业试听班）
     */
    @ExcelProperty(value="试听班级名称(yyyy-MMxxx专业试听班)",index=1)
    private String classesName;

    /**
     * 试听专业名称
     */
    @ExcelProperty(value="试听专业名称",index=2)
    private String majorName;
    /**
     * 班主任编号
     */
    @ExcelProperty(value="班主任名称",index=3)
    private String managerId;

    /**
     * 代课老师编号
     */
    @ExcelProperty(value="代课老师名称",index=4)
    private String teacherName;

    /**
     * 试听教室名称
     */
    @ExcelProperty(value="试听教室名称",index=5)
    private String classesRoom;

    /**
     * 试听开始时间
     */
    @ExcelProperty(value="试听开始时间",index=6,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date beginDate;

    /**
     * 试听结束时间（正常情况是一周）
     */
    @ExcelProperty(value="试听结束时间",index=7,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

    /**
     * 创建时间
     */
    @ExcelProperty(value="创建时间",index=8,format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    public String getClassesId() {
		return classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}


	public String getClassesRoom() {
		return classesRoom;
	}


	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setClassesRoom(String classesRoom) {
		this.classesRoom = classesRoom;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
