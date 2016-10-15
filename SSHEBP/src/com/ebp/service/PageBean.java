package com.ebp.service;

import java.util.List;

public class PageBean<E> {
	
	private List<E> list;
	private int totalRecord;//共多少条记录
	private int totalPage;//共多少页
	private int currentPage;//当前页
	private int previousPage;//上一页
	private int nextPage;//下一页
	private int pageSize;//每页显示多少条记录
	private int[] pageBar;
	
	public PageBean() {
		super();
	}
 
	

	public PageBean(List<E> list, int totalRecord, int totalPage,
			int currentPage, int previousPage, int nextPage, int pageSize,
			int[] pageBar) {
		super();
		this.list = list;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.setPreviousPage(previousPage);
		this.nextPage = nextPage;
		this.pageSize = pageSize;
		this.pageBar = pageBar;
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

	public int getTotalPage() {
		totalPage = totalRecord/pageSize + ((totalRecord % pageSize == 0) ? 0 : 1);
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPreviousPage() {
		
		if(currentPage - 1 < 1){
			previousPage = 1;
		}else{
			previousPage = currentPage - 1;
		}
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		if(currentPage + 1 > totalPage){
			nextPage = totalPage;
		}else{
			nextPage = currentPage + 1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int[] getPageBar() {
		
		if(totalPage <= 3){
			pageBar = new int[totalPage];
			for(int i = 0; i < totalPage ;i ++){
				pageBar[i] = i+1;
			}
		}else{
			pageBar = new int [3];
			int first = currentPage-1;
			int last = currentPage+1;
			if(first <= 1){
				first = 1;
				last = 3;
			}
			if(last >= totalPage){
				last = totalPage;
				first = totalPage - 2;
			}
			int index = 0;
			for(int i = first;i <= last;i++){
				pageBar[index++] = i;
			}
		}
		
		return pageBar;
	}

	public void setPageBar(int[] pageBar) {
		this.pageBar = pageBar;
	}

}
