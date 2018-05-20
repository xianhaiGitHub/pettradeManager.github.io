package com.zxh.pettrade.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单项表
 * @author zhaoxianhai
 *
 */

@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "itemid")
    private Integer itemId;

	/**
	 * 购买数量
	 */
	@Column(name="count")
    private Integer count;

	/**
	 * 小计
	 */
	@Column(name="subtotal")
    private Float subtotal;

	/**
	 * 宠物的外键, 单向多对一
	 */
    @JoinColumn(name = "pid")
    @ManyToOne
    private Pet pet;

    /**
     * 订单外键
     */
    @JoinColumn(name = "oid")
    @ManyToOne
    private Orders order;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	
}
