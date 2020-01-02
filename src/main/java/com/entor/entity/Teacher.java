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
@TableName("crm_teacher")
public class Teacher extends BaseRowModel implements Serializable {

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
    private String teacherId;

    /**
     * 教师姓名
     */
    @ExcelProperty(value="姓名",index=1)
    private String teacherName;

    /**
     * 教师性别
     */
    @ExcelProperty(value="性别",index=2)
    private Integer teacherSex;

    /**
     * 联系电话
     */
    @ExcelProperty(value="联系电话",index=3)
    private String teacherPhone;

    /**
     * 联系地址
     */
    @ExcelProperty(value="联系地址",index=4)
    private String teacherAddress;

    /**
     * 教师学历
     */
    @ExcelProperty(value="教师学历",index=5)
    private String teacherEduLevel;

    /**
     * 教师职称
     */
    @ExcelProperty(value="教师职称",index=6)
    private String teacherSkill;

    /**
     * 毕业学校名称
     */
    @ExcelProperty(value="毕业学校名称",index=7)
    private String teacherSchoolName;

    /**
     * 毕业专业名称
     */
    @ExcelProperty(value="毕业专业名称",index=8)
    private String teacherMajorName;

    /**
     * 毕业日期
     */
    @ExcelProperty(value="毕业日期",index=9,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date teacherLeaveSchoolDate;

    /**
     * 教师工作职位
     */
    @ExcelProperty(value="教师工作职位",index=10)
    private String teacherJob;

    /**
     * 入职日期
     */
    @ExcelProperty(value="入职日期",index=11,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date teacherEntryDate;

    /**
     * 离职日期
     */
    @ExcelProperty(value="离职日期",index=12,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date teacherEndDate;

    /**
     * 教师状态（1在职2离职）
     */
    @ExcelProperty(value="教师状态（1在职2离职）",index=13)
    private Integer teacherStatue;

    /**
     * 教师头像地址
     */
    @ExcelProperty(value="教师头像地址",index=14)
    private String teacherPic;

    /**
     * 创建时间
     */
    @ExcelProperty(value="创建时间",index=15,format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(Integer teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherEduLevel() {
        return teacherEduLevel;
    }

    public void setTeacherEduLevel(String teacherEduLevel) {
        this.teacherEduLevel = teacherEduLevel;
    }

    public String getTeacherSkill() {
        return teacherSkill;
    }

    public void setTeacherSkill(String teacherSkill) {
        this.teacherSkill = teacherSkill;
    }

    public String getTeacherSchoolName() {
        return teacherSchoolName;
    }

    public void setTeacherSchoolName(String teacherSchoolName) {
        this.teacherSchoolName = teacherSchoolName;
    }

    public String getTeacherMajorName() {
        return teacherMajorName;
    }

    public void setTeacherMajorName(String teacherMajorName) {
        this.teacherMajorName = teacherMajorName;
    }

    public Date getTeacherLeaveSchoolDate() {
        return teacherLeaveSchoolDate;
    }

    public void setTeacherLeaveSchoolDate(Date teacherLeaveSchoolDate) {
        this.teacherLeaveSchoolDate = teacherLeaveSchoolDate;
    }

    public String getTeacherJob() {
        return teacherJob;
    }

    public void setTeacherJob(String teacherJob) {
        this.teacherJob = teacherJob;
    }

    public Date getTeacherEntryDate() {
        return teacherEntryDate;
    }

    public void setTeacherEntryDate(Date teacherEntryDate) {
        this.teacherEntryDate = teacherEntryDate;
    }

    public Date getTeacherEndDate() {
        return teacherEndDate;
    }

    public void setTeacherEndDate(Date teacherEndDate) {
        this.teacherEndDate = teacherEndDate;
    }

    public Integer getTeacherStatue() {
        return teacherStatue;
    }

    public void setTeacherStatue(Integer teacherStatue) {
        this.teacherStatue = teacherStatue;
    }

    public String getTeacherPic() {
        return teacherPic;
    }

    public void setTeacherPic(String teacherPic) {
        this.teacherPic = teacherPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", teacherSex=" + teacherSex +
        ", teacherPhone=" + teacherPhone +
        ", teacherAddress=" + teacherAddress +
        ", teacherEduLevel=" + teacherEduLevel +
        ", teacherSkill=" + teacherSkill +
        ", teacherSchoolName=" + teacherSchoolName +
        ", teacherMajorName=" + teacherMajorName +
        ", teacherLeaveSchoolDate=" + teacherLeaveSchoolDate +
        ", teacherJob=" + teacherJob +
        ", teacherEntryDate=" + teacherEntryDate +
        ", teacherEndDate=" + teacherEndDate +
        ", teacherStatue=" + teacherStatue +
        ", teacherPic=" + teacherPic +
        ", createTime=" + createTime +
        "}";
    }
}
