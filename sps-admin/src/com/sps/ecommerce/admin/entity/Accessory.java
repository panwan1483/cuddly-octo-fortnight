package com.sps.ecommerce.admin.entity;
import java.io.Serializable;
import java.util.Date;

public class Accessory implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 扩展信息，比如：jpg
	 */
	private String ext;
	/**
	 * 宽度
	 */
	private int width;
	/**
	 * 高度
	 */
	private int height;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 标记
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Accessory(){
		super();
	}
	
	public Accessory(Long id, String ext, int width, int height, String name, String path, String remark,
			Date createTime) {
		super();
		this.id = id;
		this.ext = ext;
		this.width = width;
		this.height = height;
		this.name = name;
		this.path = path;
		this.remark = remark;
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
