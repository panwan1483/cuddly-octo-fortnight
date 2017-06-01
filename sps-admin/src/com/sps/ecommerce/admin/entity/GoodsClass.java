package com.sps.ecommerce.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类
 * @author Administrator
 */

public class GoodsClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 分类名称
	 */
	private String className;
	/**
	 * 是否显示,1为显示，0为不显示
	 */
	private Integer display;
	/**
	 * 层级别
	 */
	private int level;
	/**
	 * 是否推荐,1为推荐,0为不推荐
	 */
	private Integer recommend;
	/**
	 * 序列
	 */
	private int sequence;
	/**
	 * 商品分类ID
	 */
	private Long clickNumber;
	/**
	 * 所属父类ID
	 */
	private Long parentId;
	/**
	 * SEO扫描
	 */
	private String seoDescription;
	/**
	 * SEO关键字
	 */
	private String seoKeywords;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public GoodsClass(){
		super();
	}

	public GoodsClass(Long id, String className, Integer display, int level, Integer recommend, int sequence,
			Long clickNumber, Long parentId, String seoDescription, String seoKeywords, Date createTime) {
		super();
		this.id = id;
		this.className = className;
		this.display = display;
		this.level = level;
		this.recommend = recommend;
		this.sequence = sequence;
		this.clickNumber = clickNumber;
		this.parentId = parentId;
		this.seoDescription = seoDescription;
		this.seoKeywords = seoKeywords;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Long getclickNumber() {
		return clickNumber;
	}

	public void setclickNumber(Long clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
