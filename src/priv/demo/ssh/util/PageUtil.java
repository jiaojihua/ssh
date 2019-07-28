package priv.demo.ssh.util;

/**
 * 分页工具
 * @author 焦计划
 * @date 2019年7月28日 下午2:04:50
 */
public class PageUtil {
	private int totalCount;// 总数
	private int pageSize = 10;// 每页显示数量
	private int currentPage;// 当前页
	private int pageCount;// 总页数
	private int prePage;// 上一页
	private int nextPage;// 下一页
	private boolean hasNexePage;// 是否有下一页
	private boolean hasPrePage;// 是否有上一页
	private int firstPage;// 第一页
	private int lastPage;// 最后一页
	private int currentCount;// 当前从第多少条数据开始显示

	public PageUtil() {
		super();
	}

	public PageUtil(int totalCount, int pageNum) {
		super();
		this.totalCount = totalCount;
		this.currentPage = pageNum;
		this.pageCount = (int) Math.ceil(1.0 * totalCount / pageSize);
		this.currentCount = (currentPage - 1) * pageSize;
		if (pageNum > 1) {// 判断是否是第一页
			this.hasPrePage = true;
			this.prePage = pageNum - 1;
			this.firstPage = 1;
		}
		if (pageNum < pageCount) {// 判断是否是最后 一页
			this.hasNexePage = true;
			this.nextPage = pageNum + 1;
			this.lastPage = pageCount;
		}
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.pageCount = (int) Math.ceil(1.0 * totalCount / pageSize);
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		this.currentCount = (this.currentPage - 1) * this.pageSize;
		if (currentPage > 1) {// 判断是否是第一页
			this.hasPrePage = true;
			this.prePage = currentPage - 1;
			this.firstPage = 1;
		}
		if (currentPage < pageCount) {// 判断是否是最后 一页
			this.hasNexePage = true;
			this.nextPage = currentPage + 1;
			this.lastPage = pageCount;
		}
		this.totalCount = totalCount;

	}

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

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isHasNexePage() {
		return hasNexePage;
	}

	public void setHasNexePage(boolean hasNexePage) {
		this.hasNexePage = hasNexePage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

}
