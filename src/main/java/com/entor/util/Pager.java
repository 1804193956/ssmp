package com.entor.util;

import java.util.List;




public class Pager<T> {

	private int sp;
	private int total;
	private int pageSize;
	private int pageCount;
	private List<T> list;
	
	public Pager() {
	}
	public Pager(String currentpage,int total) {
		this(currentpage,total,20);
	}
	public Pager(String currentpage,int total, int pageSize) {
		this.total = total;
		this.pageSize = pageSize;
		pageCount = total/pageSize;
		if(total%pageSize!=0) {
			pageCount++;
		}
		try {
			sp = Integer.parseInt(currentpage);
		}catch(Exception e) {
			sp = 1;
		}
		if(sp>pageCount) {
			sp = pageCount;
		}
		if(sp<1) {
			sp = 1;
		}
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
