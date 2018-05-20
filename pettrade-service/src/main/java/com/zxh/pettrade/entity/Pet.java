package com.zxh.pettrade.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 宠物实体
 * @author zhaoxianhai
 *
 */
@Table(name="pet")
@Entity
public class Pet implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer pid;
	
	@Column(name="pname",nullable=false,length=255)
	private String  pname;
	
	@Column(name="mark_price")
	private Float markPrice;
	
	@Column(name="shop_price")
	private Float shopPrice;
	
	@Column(name="inventory")
	private Integer inventory;
	
	@Column(name="image",length=255)
	private String image;
	
	@Column(name="pdesc",length=255)
	private String pdesc;
	
	@Column(name="is_hot")
	private Integer isHot;
	
	@Column(name="pdate")
	private Date pdate;

	@JoinColumn(name = "csid")
	@ManyToOne
	private CategorySecond categorySecond;
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Float getMarkPrice() {
		return markPrice;
	}

	public void setMarkPrice(Float markPrice) {
		this.markPrice = markPrice;
	}

	public Float getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(Float shopPrice) {
		this.shopPrice = shopPrice;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	@Override
	public String toString() {
		return "Pet [pid=" + pid + ", pname=" + pname + ", markPrice=" + markPrice + ", shopPrice=" + shopPrice
				+ ", inventory=" + inventory + ", image=" + image + ", pdesc=" + pdesc + ", isHot=" + isHot + ", pdate="
				+ pdate + ", categorySecond=" + categorySecond + "]";
	}
	
}
