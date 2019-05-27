package com.lh.it.resource.common.entity;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.google.common.collect.Lists;
/**
 * @version:
* @Description: 公共基础数据类
* @author: GBY
* @date: 2018年12月13日下午5:28:58
 */
@Entity
@Table(name="BASICS_DATA_INFO")
public class BasicsDataInfo implements Comparable<BasicsDataInfo>, Idable<Long> {
	
	public static final Long ROOT_NODE_ID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 名称
	 */
	@NotBlank
	@Length(min=1, max=32)
	@Column(nullable=false, length=32)
	private String name;
	
	/**
	 * 顺序等级
	 */
	@NotNull
	@Range(min=1, max=99)
	@Column(length=2)
	private Integer grade = 1;
	
	/**
	 * 所属名称
	 */
	@NotBlank
	@Length(min=1, max=32)
	@Column(nullable=false, length=32, unique=true)
	private String sn;
	
	/**
	 * 顺序等级
	 */
	@NotNull
	@Range(min=1, max=10)
	@Column(name = "c_grade", length=2)
	private Integer cGrade = 1;
	
	/**
	 * 描述
	 */
	@Length(max=255)
	@Column(length=255)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private BasicsDataInfo parent;
	
	/**
	 * 获取每个子集下的列表
	 */
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="parent")
	@OrderBy("grade ASC")
	private List<BasicsDataInfo> children = Lists.newArrayList();
	
	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getcGrade() {
		return cGrade;
	}

	public void setcGrade(Integer cGrade) {
		this.cGrade = cGrade;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BasicsDataInfo getParent() {
		return parent;
	}

	public void setParent(BasicsDataInfo parent) {
		this.parent = parent;
	}

	public List<BasicsDataInfo> getChildren() {
		return children;
	}

	public void setChildren(List<BasicsDataInfo> children) {
		this.children = children;
	}

	public int compareTo(BasicsDataInfo b) {
		if (b == null) {
			return -1;
		} else if (b == this) {
			return 0;
		} else if (this.grade < b.getGrade()) {
			return -1;
		} else if (this.grade > b.getGrade()) {
			return 1;
		}

		return 0;	
	}
	
	public static String toJsonStr(Iterator<BasicsDataInfo> iter) {
		StringBuffer val = new StringBuffer("[");
		while (iter.hasNext()) {
			BasicsDataInfo fun = iter.next();
			val.append("{\"id\":");
			val.append(fun.getId());
			val.append(",\"name\":\"");
			val.append(fun.getName());
			val.append("\",\"pid\":");
			val.append(fun.getParent() == null ? 0 : fun.getParent().getId());
			val.append(",\"pidname\":\"");
			val.append(fun.getParent() == null ? 0 : fun.getParent().getName());
			val.append("\"");
			val.append("},");
		}
		int start = val.lastIndexOf(",") < 1 ? val.length() : val.lastIndexOf(",");
		val.replace(start, val.length(), "]");
		return val.toString();
	}
	
}
