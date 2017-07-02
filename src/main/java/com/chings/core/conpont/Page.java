package com.chings.core.conpont;

import java.util.List;

public class Page<T> {
	
	private int currentPage = 1; // 当前页
    public int totalPages = 0; // 总页数
    private int pageSize = 5;// 每页多少条数据
    private int totalRows = 0; // 总数据数
    
    private boolean hasNextPage = false; // 是否有下一页
    private boolean hasPreviousPage = false; // 是否有前一页
    
    //pageStartRow,pageEndRow是上面的变量计算出来的
    private int pageStartRow = 0;// 从第几条开始查询
    private int pageEndRow = 0; // 查询到第几条数据
    
    private List<T> list; //查询结果
    
    private Object other;//携带的额外数据
    
	public Page() {
		super();
		countSelectRows();
	}
	
	/**
	 * 查询数据时调用
	 * @param currentPage
	 * @param pageSize
	 */
	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		countSelectRows();
		
	}
	
	/**
	 * 计算要查询出来的条目的起止位置
	 */
	private void countSelectRows(){
		this.pageStartRow = (currentPage-1)*pageSize;
		this.pageEndRow = currentPage*pageSize;
	}
	
	/**
	 * 页码查询后，在返回之前调用，初始化总页数，是否有上一页，下一页的变量
	 * @param totalRows 数据总条目数
	 */
	public void init(int totalRows){
		setTotalRows(totalRows);
		isHasPreviousPage();
		isHasNextPage();
	}


	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		countSelectRows();
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	    this.totalPages=(totalRows+this.pageSize-1)/this.pageSize; 
	}
	public boolean isHasNextPage() {
		this.hasNextPage = currentPage<totalPages?true:false;
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		this.hasPreviousPage = (currentPage>1)?true:false;
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public int getPageStartRow() {
		return pageStartRow;
	}
	public void setPageStartRow(int pageStartRow) {
		this.pageStartRow = pageStartRow;
	}
	public int getPageEndRow() {
		return pageEndRow;
	}
	public void setPageEndRow(int pageEndRow) {
		this.pageEndRow = pageEndRow;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

}
