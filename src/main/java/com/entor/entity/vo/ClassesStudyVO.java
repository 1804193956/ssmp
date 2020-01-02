package com.entor.entity.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 正常班实体类
 * 
 * @author Administrator
 *
 */
public class ClassesStudyVO extends BaseRowModel implements Serializable {
	private static final long serialVersionUID = -7406320756015260668L;
	/**
	 * 每列样式
	 */
	@TableField(exist = false)
	private Map<Integer, CellStyle> cellStyleMap;

	@ExcelProperty(value = "编号", index = 0)
	@TableId(type = IdType.ASSIGN_UUID, value = "classes_id")
	private String classesId;// 主键编号
	
	@ExcelProperty(value = "班级名称", index = 1)
	private String classesName;// 班级名称（格式：yyyy-MMxxx专业班）
	
	@ExcelProperty(value = "专业名称", index = 2)
	private String majorName;// 所学专业编号
	
	@ExcelProperty(value = "班主任", index = 3)
	private String manager;// 班主任
	
	@ExcelProperty(value = "代课老师", index = 4)
	private String teacher;// 代课老师
	
	@ExcelProperty(value = "教室名称", index = 5)
	private String classesRoom;// 教室名称 implements Serializable
	
	@ExcelProperty(value = "首次开班时间", index = 6, format = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date beginDate;// 首次开班日期
	
	@ExcelProperty(value = "最后一次合班时间", index = 7, format = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastJoinDate;// 最后一次合班日期
	
	@ExcelProperty(value = "合班次数", index = 8)
	private Integer joinCount;// 合班次数
	
	@ExcelProperty(value = "结束时间", index = 9, format = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endDate;// 结束时间(正常为4个月
	
	@ExcelProperty(value = "最后结课日期", index = 10, format = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastEndDate;// 最后结课日期
	
	@ExcelProperty(value = "创建时间", index = 11, format = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp createTime;// 创建时间

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

	public String getClassesRoom() {
		return classesRoom;
	}

	public void setClassesRoom(String classesRoom) {
		this.classesRoom = classesRoom;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getLastJoinDate() {
		return lastJoinDate;
	}

	public void setLastJoinDate(Date lastJoinDate) {
		this.lastJoinDate = lastJoinDate;
	}

	public Integer getJoinCount() {
		return joinCount;
	}

	public void setJoinCount(Integer joinCount) {
		this.joinCount = joinCount;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getLastEndDate() {
		return lastEndDate;
	}

	public void setLastEndDate(Date lastEndDate) {
		this.lastEndDate = lastEndDate;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ClassesStudy [classesId=" + classesId + ", classesName=" + classesName + ", major=" + majorName
				+ ", manager=" + manager + ", teacher=" + teacher + ", classesRoom=" + classesRoom + ", beginDate="
				+ beginDate + ", lastJoinDate=" + lastJoinDate + ", joinCount=" + joinCount + ", endDate=" + endDate
				+ ", lastEndDate=" + lastEndDate + ", createTime=" + createTime + "]";
	}

}
