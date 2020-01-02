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
@TableName("crm_borrow_org")
public class BorrowOrg extends BaseRowModel implements Serializable {

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
     * 贷款机构名称
     */
    @ExcelProperty(value="贷款机构名称",index=1)
    private String name;

    /**
     * 机构描述
     */
    @ExcelProperty(value="机构描述",index=2)
    private String remark;

    /**
     * 合作开始日期
     */
    @ExcelProperty(value="合作开始日期",index=3,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date beginDate;

    /**
     * 合作结束日期
     */
    @ExcelProperty(value="合作结束日期",index=4,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

    /**
     * 合作机构负责人
     */
    @ExcelProperty(value="合作机构负责人",index=5)
    private String manager;

    /**
     * 合作机构联系方式
     */
    @ExcelProperty(value="合作机构联系方式",index=6)
    private String phone;

    /**
     * 创建时间
     */
    @ExcelProperty(value="创建时间",index=7,format="yyyy-MM-dd")
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BorrowOrg{" +
        "id=" + id +
        ", name=" + name +
        ", remark=" + remark +
        ", beginDate=" + beginDate +
        ", endDate=" + endDate +
        ", manager=" + manager +
        ", phone=" + phone +
        ", createTime=" + createTime +
        "}";
    }
}
