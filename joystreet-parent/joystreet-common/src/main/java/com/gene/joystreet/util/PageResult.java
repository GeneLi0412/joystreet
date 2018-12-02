package com.gene.joystreet.util;

import java.io.Serializable;
import java.util.List;

/**
 * 保存分页结果
 * @author: LJP
 * @date: 2018年12月2日 上午12:25:57
 */
public class PageResult<T> implements Serializable{
	
	private static final long serialVersionUID = 7528893190258479703L;

	/**
	 * 总条数
	 */
	private long total;
	
	/**
	 * 数据
	 */
	private List<T> rows;
	
	public PageResult() {
	}

	public PageResult(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
