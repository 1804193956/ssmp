package com.entor.entity;

import com.alibaba.excel.annotation.ExcelProperty;
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
@TableName("crm_classes_study")
public class ClassesStudy extends BaseRowModel implements Serializable {

    private static final long serialVersionUID=1L;

    /**
	 * 每列样式
	 */
	@TableField(exist = false)
	private Map<Integer, CellStyle> cellStyleMap;
    
    /**
     * 主键编号
     */
	@ExcelProperty(value = "编号", index = 0)
    @TableId(type=IdType.ASSIGN_UUID,value="classes_id")
    private String classesId;

    /**
     * 班级名称（格式：yyyy-MMxxx专业班）
     */
	@ExcelProperty(value = "班级名称", index = 1)
    private String classesName;

    /**
     * 所学专业编号
     */
	@ExcelProperty(value = "专业名称", index = 2)
    private String majorId;

    /**
     * 班主任编号
     */
	@ExcelProperty(value = "班主任", index = 3)
    private String managerId;

    /**
     * 代课老师编号
     */
	@ExcelProperty(value = "代课老师", index = 4)
    private String teacherId;

    /**
     * 教室名称
     */
	@ExcelProperty(value = "教室名称", index = 5)
    private String classesRoom;

    /**
     * 首次开班日期
     */
	@ExcelProperty(value = "首次开班时间", index = 6, format = "yyyy-MM-dd")
    private Date beginDate;

    /**
     * 最后一次合班日期
     */
	@ExcelProperty(value = "最后一次合班时间", index = 7, format = "yyyy-MM-dd")
    private Date lastJoinDate;

    /**
     * 合班次数
     */
	@ExcelProperty(value = "合班次数", index = 8)
    private Integer joinCount;

    /**
     * 结课日期（正常情况是四个月）
     */
	@ExcelProperty(value = "结束时间", index = 9, format = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 最后结课日期
     */
	@ExcelProperty(value = "最后结课日期", index = 10, format = "yyyy-MM-dd")
    private Date lastEndDate;

    /**
     * 创建时间
     */
	@ExcelProperty(value = "创建时间", index = 11, format = "yyyy-MM-dd")
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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassesRoom() {
        return classesRoom;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ClassesStudy{" +
        "classesId=" + classesId +
        ", classesName=" + classesName +
        ", majorId=" + majorId +
        ", managerId=" + managerId +
        ", teacherId=" + teacherId +
        ", classesRoom=" + classesRoom +
        ", beginDate=" + beginDate +
        ", lastJoinDate=" + lastJoinDate +
        ", joinCount=" + joinCount +
        ", endDate=" + endDate +
        ", lastEndDate=" + lastEndDate +
        ", createTime=" + createTime +
        "}";
    }
}
