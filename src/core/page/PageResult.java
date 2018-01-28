package core.page;

import java.util.List;

public class PageResult {
	private long totalCount;
	private int pageCount;
	private int currentPage;
	private int pageSize;
	private List<Object> items;
	
	
	public PageResult(long totalCount, int currentPage, int pageSize, List<Object> items) {
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.items = items;
		if(totalCount!=0){
		int temp=(int) (totalCount/pageSize);
		this.pageCount=(totalCount%pageSize==0)?temp:temp+1;
		this.currentPage = currentPage;
		}else{
			this.currentPage=0;
		}
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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
	public List<Object> getItems() {
		return items;
	}
	public void setItems(List<Object> items) {
		this.items = items;
	}
}
