package com.zxh.pettrade.bean;

import com.zxh.pettrade.entity.Pet;

/**
 * 购物车项信息
 * @author zhaoxianhai
 *
 */
public class CartItem {
	//宠物信息
	private Pet pet;
	
	//价格
	private Float price = 1.0f;
	
	//宠物数量
	private int count;
	
	//小计
	@SuppressWarnings("unused")
	private float subtotal;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getSubtotal() {
		return count * getPrice();
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
}
