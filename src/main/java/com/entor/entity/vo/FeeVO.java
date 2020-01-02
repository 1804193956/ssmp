package com.entor.entity.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeVO  extends BaseRowModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3714312707260487058L;
	/**
     * 每列样式
     */
    @TableField(exist = false)
    private Map<Integer,CellStyle> cellStyleMap;
	private String id;//主键编号
	private String studentName;//学生
	private Integer payMoney;//缴费金额
	private Integer payType;//缴费方式（1全款2分期）
	private String borrowOrgName;//分期机构编号
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date payDate;//缴费日期
	private Integer payStatue;//缴费状态（1已缴费2未交费）
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Timestamp createTime;//创建时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Integer getPayStatue() {
		return payStatue;
	}
	public void setPayStatue(Integer payStatue) {
		this.payStatue = payStatue;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBorrowOrgName() {
		return borrowOrgName;
	}
	public void setBorrowOrgName(String borrowOrgName) {
		this.borrowOrgName = borrowOrgName;
	}
	@Override
	public String toString() {
		return "FeeView [id=" + id + ", studentName=" + studentName + ", payMoney=" + payMoney + ", payType=" + payType
				+ ", borrowOrgName=" + borrowOrgName + ", payDate=" + payDate + ", payStatue=" + payStatue
				+ ", createTime=" + createTime + "]";
	}
	
	
}
