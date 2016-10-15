package com.ebp.service;

import java.util.List;

public class QueryResult<E> {
	
	private List<E> list;
	private int totalRecord;
	
	public QueryResult() {
		super();
	}

	public QueryResult(List<E> list, int totalRecord) {
		super();
		this.list = list;
		this.totalRecord = totalRecord;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	

}
