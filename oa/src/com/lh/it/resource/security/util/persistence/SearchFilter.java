package com.lh.it.resource.security.util.persistence;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

/**
 * 动态查询对象，是个封装所有查询规则。
 * 
 * @author <a href="mailto:ketayao@gmail.com">ketayao</a>
 * @author zhoushuai@189.cn
 * @since 2013年10月31日 上午11:30:53
 */
public class SearchFilter {
	/** 查询字段名称 */
	private String fieldName;
	/** 查询字段的值 */
	private Object value;
	/** 查询字段查询规则 */
	private Operator operator;

	/**
	 * 
	 * @param fieldName
	 * @param operator
	 * @param value
	 */
	public SearchFilter(String fieldName, Operator operator, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	/**
	 * searchParams中key的格式为OPERATOR_FIELDNAME
	 */
	public static Map<String, SearchFilter> parse(
			Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = Maps.newHashMap();

		for (Entry<String, Object> entry : searchParams.entrySet()) {
			// 过滤掉空值
			String key = entry.getKey();
			Object value = entry.getValue();
			if (StringUtils.isBlank((String) value)) {
				continue;
			}

			// 拆分operator与filedAttribute
			String[] names = StringUtils.split(key, "_");
			if (names.length != 2) {
				throw new IllegalArgumentException(key
						+ " is not a valid search filter name");
			}
			String filedName = names[1];
			Operator operator = Operator.valueOf(names[0]);

			// 创建searchFilter
			SearchFilter filter = new SearchFilter(filedName, operator, value);
			filters.put(key, filter);
		}

		return filters;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * 创建一个相等查询查询对象{@link SearchFilter}
	 * 
	 * @param field
	 *            查询字段
	 * @param value
	 *            查询值
	 * @return 返回等于结果的查询对象
	 */
	public static SearchFilter newEQ(String field, Object value) {
		return new SearchFilter(field, Operator.EQ, value);
	}

	/**
	 * 创建一个模糊查询对象{@link SearchFilter}
	 * 
	 * @param field
	 *            查询字段
	 * @param value
	 *            查询值
	 * @return 返回等于结果的查询对象
	 */
	public static SearchFilter newLIKE(String field, Object value) {
		return new SearchFilter(field, Operator.LIKE, value);
	}

	/**
	 * 创建一个大于查询对象{@link SearchFilter}
	 * 
	 * @param field
	 *            查询字段
	 * @param value
	 *            查询值
	 * @return 返回等于结果的查询对象
	 */
	public static SearchFilter newGT(String field, Object value) {
		return new SearchFilter(field, Operator.GT, value);
	}

	/**
	 * 创建一个小于查询对象{@link SearchFilter}
	 * 
	 * @param field
	 *            查询字段
	 * @param value
	 *            查询值
	 * @return 返回等于结果的查询对象
	 */
	public static SearchFilter newLT(String field, Object value) {
		return new SearchFilter(field, Operator.LT, value);
	}

	/**
	 * 创建一个大于等于查询对象{@link SearchFilter}
	 * 
	 * @param field
	 *            查询字段
	 * @param value
	 *            查询值
	 * @return 返回等于结果的查询对象
	 */
	public static SearchFilter newGTE(String field, Object value) {
		return new SearchFilter(field, Operator.GTE, value);
	}

	/**
	 * 创建一个小于等于查询对象{@link SearchFilter}
	 * 
	 * @param field
	 *            查询字段
	 * @param value
	 *            查询值
	 * @return 返回等于结果的查询对象
	 */
	public static SearchFilter newLTE(String field, Object value) {
		return new SearchFilter(field, Operator.LTE, value);
	}

	/**
	 * 查询规则
	 * 
	 * @author zhoushuai@189.cn
	 * 
	 */
	public enum Operator {
		/**
		 * 等于
		 */
		EQ,
		/**
		 * 模糊
		 */
		LIKE,
		/**
		 * 大于
		 */
		GT,
		/**
		 * 小于
		 */
		LT,
		/**
		 * 大于等于
		 */
		GTE,
		/**
		 * 小于等于
		 */
		LTE
	}
}