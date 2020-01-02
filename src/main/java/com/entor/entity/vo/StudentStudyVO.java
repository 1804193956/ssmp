package com.entor.entity.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * 学生信息
 * 
 */
public class StudentStudyVO extends BaseRowModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6946409217403997124L;
	/**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
    
    @ExcelProperty(value="编号",index=0)
	private String id;//主键编号
    @ExcelProperty(value="学生姓名",index=1)
	private String name;//学生姓名
    @ExcelProperty(value="性别",index=2)
	private Integer sex;//学生性别
    @ExcelProperty(value="联系电话",index=3)
	private String phone;//联系电话
    @ExcelProperty(value="联系地址",index=4)
	private String address;//联系地址
    @ExcelProperty(value="毕业学校名称",index=5)
	private String schoolName;//毕业学校名称
    @ExcelProperty(value="毕业专业名称",index=6)
	private String schoolMajor;//专业名称
    @ExcelProperty(value="开班日期",index=7,format="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date beginDate;//开班日期
    @ExcelProperty(value="实训专业",index=8)
	private String majorName;//实训专业编号
    @ExcelProperty(value="合同编号",index=9)
	private String contractId;//合同编号
    @ExcelProperty(value="合同文件名称",index=10)
	private String contractFile;//合同文件名称
    @ExcelProperty(value="合同签订日期",index=11,format="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date contractDate;//合同签订日期
    @ExcelProperty(value="创建时间",index=12,format="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp createTime;//创建时间
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
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolMajor() {
		return schoolMajor;
	}
	public void setSchoolMajor(String schoolMajor) {
		this.schoolMajor = schoolMajor;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getContractFile() {
		return contractFile;
	}
	public void setContractFile(String contractFile) {
		this.contractFile = contractFile;
	}
	public Date getContractDate() {
		return contractDate;
	}
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "StudentStudy [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", address="
				+ address + ", schoolName=" + schoolName + ", schoolMajor=" + schoolMajor + ", beginDate=" + beginDate
				+ ", major=" + majorName + ", contractId=" + contractId + ", contractFile=" + contractFile
				+ ", contractDate=" + contractDate + ", createTime=" + createTime + "]";
	}
	
	
	
}
