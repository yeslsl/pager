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
	 * @param pageNum ��ѯ�ڼ�ҳ������
	 * @param pageSize ÿҳ��ʾ�ļ�¼��
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
	
	
	private int pageSize;//ÿҳ��ʾ��������¼;
	private int currentPage;//��ǰ�ڼ�ҳ����;
	private int totalRecord;//һ����������¼;
	private int totalPage;//һ������ҳ��¼;
	private List<T> dataList;//Ҫ��ʾ������;
	
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
