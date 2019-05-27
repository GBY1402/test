package com.lh.it.resource.security.util.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletRequest;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Lists;
import com.lh.it.resource.security.SecurityConstants;
import com.lh.it.resource.utils.Exceptions;
import com.lh.it.resource.utils.ServletUtils;
/**
 * 
 * 动态生成页面查询条件的功能类，通过功能类可以手动和自动种方式结合的生成查询规格。
 * @author <a href="mailto:ketayao@gmail.com">ketayao</a>
 * @author zhoushuai@189.cn
 *
 */
public class DynamicSpecifications {
	private static final Logger logger = LoggerFactory.getLogger(DynamicSpecifications.class);
	
	private static final String SHORT_DATE = "yyyy-MM-dd";
	private static final String LONG_DATE = "yyyy-MM-dd mm:HH:ss";
	private static final String TIME = "mm:HH:ss";
	
	/**
	 * 获得{@link ServletRequest}请求实体中所有以“search_”开头的查询参数，并根据规则生成查询规格。
	 * @param request 存储查询参数的请求实体
	 * @return 返回请求实体中所有以“search_”开头的参数集合
	 */
	public static Collection<SearchFilter> genSearchFilter(ServletRequest request) {
		if (request != null) {
			Map<String, Object> searchParams = ServletUtils.getParametersStartingWith(request, SecurityConstants.SEARCH_PREFIX);
			Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
			return filters.values();
		}
		return new HashSet<SearchFilter>(0);
	}
	
	/**
	 * 根据查询条件和实体类型来自动生成查询规格。
	 * 
	 * @param entityClazz 生成查询规格类型
	 * @param searchFilters 查询条件集合
	 * @return 返回根据查询条件和实体类型来自动生成查询规格集合。
	 */
	public static <T> Specification<T> bySearchFilter(final Class<T> entityClazz, SearchFilter...searchFilters) {
		return bySearchFilter(null, entityClazz, searchFilters);
	}
	
	/**
	 * 对{@link ServletRequest}请求中所有查询参数和手动查询参数，根据实体类型进行动态封装成查询规则。
	 * 
	 * @param request 请求实体类型
	 * @param entityClazz 查询规则所属实体类型
	 * @param searchFilters {@link ServletRequest}之外的请求参数集合。
	 * @return 返回通过{@link ServletRequest}请求实体与请求参数集合来生成查询规格。
	 */
	public static <T> Specification<T> bySearchFilter(ServletRequest request, final Class<T> entityClazz, SearchFilter...searchFilters) {
		Collection<SearchFilter> filters = genSearchFilter(request);
		Set<SearchFilter> set = new HashSet<SearchFilter>(filters);
		for (SearchFilter searchFilter : searchFilters) {
			set.add(searchFilter);
		}
		return bySearchFilter(entityClazz, set);
	}
	/**
	 * 对所有过滤规则集合按照查询实体类型进行动态封装并返回查询集合。
	 * 
	 * @param entityClazz 查询实体类型
	 * @param filters 查询过滤条件集合
	 * @return 返回动态封装后的查询规则集合
	 */
	public static <T> Specification<T> bySearchFilter(final Class<T> entityClazz, final Collection<SearchFilter> filters) {
		return new Specification<T>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (filters != null && !filters.isEmpty()) {
					List<Predicate> predicates = Lists.newArrayList();
					for (SearchFilter filter : filters) {
						// nested path translate, 如Task的名为"user.name"的filedName, 转换为Task.user.name属性
						String[] names = StringUtils.split(filter.getFieldName(), ".");
						Path expression = root.get(names[0]);
						for (int i = 1; i < names.length; i++) {
							expression = expression.get(names[i]);
						}

						// 自动进行enum和date的转换。
						Class clazz = expression.getJavaType();
						if (Date.class.isAssignableFrom(clazz) && !filter.getValue().getClass().equals(clazz)) {
							filter.setValue(convert2Date((String)filter.getValue()));
						} else if (Enum.class.isAssignableFrom(clazz) && !filter.getValue().getClass().equals(clazz)) {
							filter.setValue(convert2Enum(clazz, (String)filter.getValue()));
						}
						
						// logic operator
						switch (filter.getOperator()) {
						case EQ:
							predicates.add(builder.equal(expression, filter.getValue()));
							break;
						case LIKE:
							predicates.add(builder.like(expression, "%" + filter.getValue() + "%"));
							break;
						case GT:
							predicates.add(builder.greaterThan(expression, (Comparable) filter.getValue()));
							break;
						case LT:
							predicates.add(builder.lessThan(expression, (Comparable) filter.getValue()));
							break;
						case GTE:
							predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.getValue()));
							break;
						case LTE:
							predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.getValue()));
							break;
						}
					}

					// 将所有条件用 and 联合起来
					if (predicates.size() > 0) {
						return builder.and(predicates.toArray(new Predicate[predicates.size()]));
					}
				}

				return builder.conjunction();
			}
		};
	}
	
	private static Date convert2Date(String dateString) {
		SimpleDateFormat sFormat = new SimpleDateFormat(SHORT_DATE);
		try {
			return sFormat.parse(dateString);
		} catch (ParseException e) {
			try {
				return sFormat.parse(LONG_DATE);
			} catch (ParseException e1) {
				try {
					return sFormat.parse(TIME);
				} catch (ParseException e2) {
					logger.error("Convert time is error! The dateString is " + dateString + "." + Exceptions.getStackTraceAsString(e2));
				}
			}
		}

		return null;
	}
		
	
	private static <E extends Enum<E>> E convert2Enum(Class<E> enumClass, String enumString) {
		return EnumUtils.getEnum(enumClass, enumString);
	}
}
