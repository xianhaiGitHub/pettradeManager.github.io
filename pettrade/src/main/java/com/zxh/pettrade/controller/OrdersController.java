package com.zxh.pettrade.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxh.pettrade.bean.Cart;
import com.zxh.pettrade.bean.CartItem;
import com.zxh.pettrade.entity.OrderItem;
import com.zxh.pettrade.entity.Orders;
import com.zxh.pettrade.entity.User;
import com.zxh.pettrade.service.OrderService;
import com.zxh.pettrade.service.PayService;

/**
 * 客户订单控制层
 * 
 * @author zhaoxianhai
 *
 */
@Controller
public class OrdersController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PayService payService;
	
	/**
	 * 提交订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/submitOrders")
	public String submitOrders(HttpSession session, Map<String, Object> map) {
		/**
		 * 判断客户是否登陆
		 */
		User user = (User) session.getAttribute("user");
		if (user == null) {
			map.put("withoutLogin", "withoutLogin");
			return "message";
		}
		/**
		 * 若登陆则从session中获取购物车对象
		 * 
		 */
		Cart cart = (Cart) session.getAttribute("cart");
		/**
		 * 判断购物车是否为空
		 */
		if (cart == null) {
			return "redirect:myCart";
		}
		/**
		 * 创建订单对象 订单状态1：未付款，2：已付款，3：已发货，4：未发货
		 */
		Orders order = new Orders();
		order.setTotal(cart.getTotal());
		order.setState(1);
		order.setOrdertime(new Date());
		order.setUser(user);
		/**
		 * 获取订单项
		 * 
		 */
		Set<OrderItem> sets = new HashSet<OrderItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setPet(cartItem.getPet());
			orderItem.setOrder(order);
			sets.add(orderItem);
		}
		order.setOrderItems(sets);
		orderService.save(order);
		/**
		 * 提交订单后清除购物车
		 * 
		 */
		cart.clearCart();
		map.put("order", order);
		return "order";
	}

	/**
	 * 确认订单,跳至支付页面,修改订单状态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orderPay")
	public String orderPay(Integer oid, String addr, String name, String phone, String total, Integer paytype,
			Map<String, Object> map) {
		Orders order = orderService.findByOid(oid);
		/**
		 * 订单支付
		 */
		if (paytype == 0) {
			int index = payService.payOrderByWallet(order, addr, name, phone, total);
			if(index == 0){
				map.put("payment", "payok");
				return "message";
			}else {
				map.put("payment", "payerror");
				return "message";
			}
		} else {
			//在线支付
			map.put("payment", "payment");
			return "message";
		}
	}
	/**
	 * 分页查询订单
	 * @param session
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/findOrderByUid/{page}")
	public String findOrderByUid(HttpSession session, Map<String, Object> map, @PathVariable("page") Integer page) {
		/**
		 * 从session中获取客户
		 */
		User user = (User) session.getAttribute("user");
		if(user == null) {
			map.put("withoutLogin", "withoutLogin");
			return "message";
		}
		Integer count = orderService.findCountByUid(user.getUid());
		List<Orders> orders = orderService.findByUid(user.getUid(), page);
		/**
		 * 放到map中
		 */
		map.put("page", page);
		map.put("count", count);
		map.put("orders", orders);
		return "orderList";
		
	}
	/**
	 * 我的订单页点击付款
	 * 通过订单id查询订单
	 * @param session
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/findByOid/{oid}")
	public String findByOid(@PathVariable("oid") Integer oid, Map<String, Object> map) {
		Orders order = orderService.findByOid(oid);
		map.put("order", order);
		return "order";
	}
}
