package com.lh.it.resource.common.entity;

import java.io.Serializable;

/**
 * @version:
* @Description: 
* @author: GBY
* @date: 2018年12月12日下午12:12:45
 */
public interface Idable<T extends Serializable> {
	public T getId();

	public void setId(T id);
}
