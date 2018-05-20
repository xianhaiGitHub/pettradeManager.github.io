package com.zxh.pettrade.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zxh.pettrade.bean.Cart;
import com.zxh.pettrade.bean.CartItem;
import com.zxh.pettrade.entity.Pet;
import com.zxh.pettrade.service.PetService;

/**
 * 购物车控制层
 * 
 * @author zhaoxianhai
 *
 */
@Controller
public class CartController {
	
	@Autowired
	private PetService petService;
	/**
	 * 进入购物车页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/myCart")
	public String myCart() {
		return "cart";
	}
	/**
	 * 添加宠物到购物车
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public String addCart(Integer pid, Integer count, HttpSession session, Map<String, Object> map) {
		Pet pet = petService.getPet(pid);
		CartItem cartItem = new CartItem();
		cartItem.setPet(pet);
		cartItem.setCount(count);
		cartItem.setPrice(pet.getShopPrice());
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addCart(cartItem);
		return "cart";
	}
	/**
	 * 删除购物车中的宠物
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteCart/{pid}")
	public String deleteCart(@PathVariable("pid") Integer pid, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.deleteCartItem(pid);
		return "cart";
	}
	/**
	 * 清空购物车
	 * 
	 * @return
	 */
	@RequestMapping(value = "/clearCart")
	public String clearCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
	
}
