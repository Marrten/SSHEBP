package com.ebp.formbean;

public class QueryBean {
	
	private int currentPage = 1;//当前页

	private int pageSize = 3;//每页有多少

	private int startIndex;
	
	public QueryBean() {
		super();
	}

	public QueryBean(int currentPage, int pageSize, int startIndex) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.startIndex = startIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getstartIndex() {
		startIndex = (currentPage - 1) * pageSize;
		return startIndex;
	}

	public void setstartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	

}
