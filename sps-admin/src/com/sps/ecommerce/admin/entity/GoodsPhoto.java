package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class GoodsPhoto implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 商品编号
	 */
	private Long goodsId;
	/**
	 * 图片编号,外键关联sps_accessory
	 */
	private Long photoId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public GoodsPhoto(){
		super();
	}
	
	public GoodsPhoto(Long id, Long goodsId, Long photoId, Date createTime) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.photoId = photoId;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getphotoId() {
		return photoId;
	}
	public void setphotoId(Long photoId) {
		this.photoId = photoId;
	}
	public Date getcreateTime() {
		return createTime;
	}
	public void setcreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
