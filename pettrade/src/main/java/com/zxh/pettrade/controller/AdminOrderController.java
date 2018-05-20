package com.zxh.pettrade.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxh.pettrade.entity.OrderItem;
import com.zxh.pettrade.entity.Orders;
import com.zxh.pettrade.service.AdminOrderService;

/**
 * 管理订单控制层
 * 
 * @author zhaoxianhai
 *
 */
@Controller
public class AdminOrderController {

	@Autowired
	private AdminOrderService adminOrderService;

	/**订单项
	 * 
	 * @param oid
	 * @param map
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findOrderItem/{oid}")
	public String findOrderItem(@PathVariable("oid") Integer oid, Map<String, Object> map, HttpServletResponse response)
			throws IOException {
		Orders order = adminOrderService.findOrder(oid);
		System.out.println(order);
		Set<OrderItem> orderItem = order.getOrderItems();
		map.put("orderItem", orderItem);
		return "admin/order/orderItem";
	}

	/**
	 * 发货
	 * 
	 * @param oid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/updateStateOrder/{oid}/{page}")
	public ModelAndView updateStateOrder(@PathVariable("oid") Integer oid, @PathVariable("page") Integer page) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listOrder/" + page);
		Orders order = adminOrderService.findOrder(oid);
		order.setState(3);
		adminOrderService.saveOrUpdateOrder(order);
		return modelAndView;
	}

	/**
	 * 查询订单
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/listOrder/{page}")
	public ModelAndView listOrder(@PathVariable("page") Integer page) {
		ModelAndView modelAndView = new ModelAndView("admin/order/list");
		/**
		 * 分页查找所有的订单
		 */
		List<Orders> orders = adminOrderService.listOrder(page, 5);
		modelAndView.addObject("orders", orders);
		/**
		 * 保存当前的页数
		 */
		modelAndView.addObject("page", page);
		/**
		 * 查询总共有多少页的数据
		 */
		Integer count = adminOrderService.countOrder();
		modelAndView.addObject("count", count);
		return modelAndView;
	}

	/**
	 * 删除订单
	 * 
	 * @param oid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteOrder/{oid}")
	public ModelAndView deletePet(@PathVariable("oid") Integer oid, HttpServletRequest request) {
		/**
		 */
		Orders order = adminOrderService.findOrder(oid);
		/**
		 * 删除宠物在数据库中的记录
		 */
		adminOrderService.deleteOrder(order);
		ModelAndView modelAndView = new ModelAndView("redirect:/listOrder/1");
		return modelAndView;
	}
}
