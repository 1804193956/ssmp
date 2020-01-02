package com.entor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author Willis
 * @since 2019-12-16
 */
@TableName("crm_major")
public class Major extends BaseRowModel implements Serializable {

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
     * 专业名称
     */
    @ExcelProperty(value="专业名称",index=1)
    private String name;

    /**
     * 专业负责人
     */
    @ExcelProperty(value="专业负责人",index=2)
    private String manager;

    /**
     * 专业描述
     */
    @ExcelProperty(value="专业描述",index=3)
    private String remark;

    /**
     * 专业创建日期
     */
    @ExcelProperty(value="专业创建日期",index=4,format="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date beginDate;


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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    @Override
    public String toString() {
    	
        return "Major{" +
        "id=" + id +
        ", name=" + name +
        ", manager=" + manager +
        ", remark=" + remark +
        ", beginDate=" + beginDate +
        "}";
    }
}
