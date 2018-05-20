package com.zxh.pettrade.bean;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车相关计算
 * 
 * @author zhaoxianhai
 *
 */
public class Cart {
	/**
	 * 创建一个存放购物车的容器map<pid,CartItem>
	 */
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

	/**
	 * 购买总计
	 */
	private float total;

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * map中得到cartItems属性
	 * @return
	 */
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	/**
	 * 向购物车添加购物项
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {
		Integer pid = cartItem.getPet().getPid();
		/**
		 * 判断购物车里时候有同类宠物
		 *
		 */
		if (map.containsKey(pid)) {
			CartItem _cartItem = map.get(pid);
			/**
			 * 同类则累加
			 */
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
		} else {
			/**
			 * 没有同类则将其添加到map
			 */
			map.put(pid, cartItem);
		}
		/**
		 * 计算总价格
		 */
		total += cartItem.getSubtotal();
	}
	/**
	 *从购物车中删除购物项
	 */
	public void deleteCartItem(Integer pid) {
		
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * 清空购物车
	 * 
	 */
	public void clearCart() {
		/**
		 * 清除map
		 */
		map.clear();
		total = 0;
	}

}
