package com.lh.it.resource.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 页面开始值为0
 * 
 * @author zhoushuai@189.cn
 * 
 */
public class PageableRequest implements Pageable {

	public static int DEFAULT_PAGE_SIZE = 20;

	public static int DEFALUT_PAGE_NO = 0;
	/** 当前页显示数据 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	/** 页码 */
	private int pageNumber = DEFALUT_PAGE_NO;

	private Sort sort;

	
	
	public PageableRequest() {
		super();
	}

	public PageableRequest(int pageNumber, int pageSize) {
		this(pageNumber, pageSize, null);
	}

	public PageableRequest(int pageNumber, int pageSize, Direction direction,
			String... properties) {
		this(pageNumber, pageSize, new Sort(direction, properties));
	}

	public PageableRequest(int pageNumber, int pageSize, Sort sort) {

		if (pageNumber < 0) {
			throw new IllegalArgumentException("Page index must not be less than zero!");
		}

		if (pageSize < 1) {
			throw new IllegalArgumentException("Page size must not be less than one!");
		}

		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sort = sort;
	}

	/**
	 * 当前页需要显示的数据
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 当前页的编号
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	public int getOffset() {
		return pageNumber * pageSize;
	}

	public Sort getSort() {
		return sort;
	}

	public boolean hasPrevious() {
		return pageNumber > 0;
	}

	public Pageable next() {
		return new PageableRequest(pageNumber + 1, pageSize, sort);
	}

	public Pageable previousOrFirst() {
		return hasPrevious() ? new PageableRequest(pageNumber, pageSize,
				sort) : this;
	}

	public Pageable first() {
		return new PageableRequest(0, pageSize, sort);
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			throw new IllegalArgumentException("Page size must not be less than one!");
		}

		this.pageSize = pageSize;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber < 0) {
			throw new IllegalArgumentException("Page index must not be less than zero!");
		}
		this.pageNumber = pageNumber;
	}
}
