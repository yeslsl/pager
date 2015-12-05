package cn.com.sealer.model;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 3284266348664234276L;

	public Pager() {
		super();
	}
	
	public Pager(int pageSize, int currentPage, int totalRecord, int totalPage, List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}
	
	
	
	/**
	 * 
	 * @param sourceList 
	 * @param pageNum 查询第几页的数据
	 * @param pageSize 每页显示的记录数
	 */
	public Pager(List<T> sourceList, int pageNum, int pageSize){
		this.pageSize = pageSize;
		this.totalRecord = sourceList.size();
		this.totalPage = this.totalRecord % this.pageSize == 0 ? this.totalRecord / this.pageSize : (this.totalRecord / this.pageSize + 1);
		this.currentPage = this.totalPage == 0 ? 1 : (this.totalPage < pageNum ? this.totalPage : pageNum);
		
		int fromIndex = this.pageSize * (this.currentPage - 1);
		int toIndex = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord : this.pageSize * this.currentPage;
		this.dataList = sourceList.subList(fromIndex, toIndex);
	}
	
	public Pager(List<T> sourceList, int pageNum, int pageSize, int totalRecord){
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.totalPage = this.totalRecord % this.pageSize == 0 ? this.totalRecord / this.pageSize : (this.totalRecord / this.pageSize + 1);
		this.currentPage = this.totalPage == 0 ? 1 : (this.totalPage < pageNum ? this.totalPage : pageNum);
		
		this.dataList = sourceList;
	}
	
	
	private int pageSize;//每页显示多少条记录;
	private int currentPage;//当前第几页数据;
	private int totalRecord;//一共多少条记录;
	private int totalPage;//一共多少页记录;
	private List<T> dataList;//要显示的数据;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
	
	
}
