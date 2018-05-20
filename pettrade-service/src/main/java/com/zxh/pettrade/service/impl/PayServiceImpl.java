package com.zxh.pettrade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.entity.OrderItem;
import com.zxh.pettrade.entity.Orders;
import com.zxh.pettrade.entity.Pet;
import com.zxh.pettrade.entity.User;
import com.zxh.pettrade.entity.Wallet;
import com.zxh.pettrade.service.OrderService;
import com.zxh.pettrade.service.PayService;
import com.zxh.pettrade.service.PetService;
import com.zxh.pettrade.service.WalletService;

@Service("payService")
@Transactional
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public int payOrderByWallet(Orders order, String addr, String name, String phone, String total) {
		order.setAddr(addr);
		order.setName(name);
		order.setPhone(phone);
		//通过订单查找客户
		User user  =order.getUser();
		//通过客户查找钱包
		Wallet wallet = user.getWallet();
		//通过钱包查余额
		Float money  = wallet.getMoney();
		//订单价格
		Float totalMoney = Float.parseFloat(total);
		if(money >= totalMoney) {
			//遍历所有订单项
			for(OrderItem orderItem : order.getOrderItems()) {
				Integer inventory = orderItem.getPet().getInventory();
				Pet pet = orderItem.getPet();
				pet.setInventory(inventory - orderItem.getCount());
				//更新宠物库存
				petService.updatePet(pet);
			}
			wallet.setMoney(money - totalMoney);
			walletService.update(wallet);
			//已付款，修改订单状态为2
			order.setState(2);
			//更新订单信息
			orderService.update(order);
			//支付成功返回0
			return 0;
		}else {
			//支付失败返回1
			return 1;
		}
	}

}
