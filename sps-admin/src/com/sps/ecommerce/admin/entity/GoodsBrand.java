package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class GoodsBrand implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 品牌名称
	 */
	private String name;
	/**
	 * 第一个单词字母，方便用户根据编号查询
	 */
	private String firstWord;
	
	/**
	 * 序列,默认排序
	 */
	private Integer sequence;
	/**
	 * 商品的附属ID
	 */
	private String logo;
	/**
	 * 品牌分类ID
	 */
	private Long goodsClassId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public GoodsBrand(){
		super();
	}

	public GoodsBrand(Long id, String name, String firstWord, Integer sequence, String logo,
			Long goodsClassId, String remark, Date createTime) {
		this.id = id;
		this.name = name;
		this.firstWord = firstWord;
		this.sequence = sequence;
		this.logo = logo;
		this.goodsClassId = goodsClassId;
		this.remark = remark;
		this.createTime = createTime;
	}

	public GoodsBrand(String name, String firstWord, Integer sequence, String logo, Long goodsClassId, String remark,
			Date createTime) {
		this.name = name;
		this.firstWord = firstWord;
		this.sequence = sequence;
		this.logo = logo;
		this.goodsClassId = goodsClassId;
		this.remark = remark;
		this.createTime = createTime;
	}

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

	public String getFirstWord() {
		return firstWord;
	}

	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getGoodsClassId() {
		return goodsClassId;
	}

	public void setGoodsClassId(Long goodsClassId) {
		this.goodsClassId = goodsClassId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
