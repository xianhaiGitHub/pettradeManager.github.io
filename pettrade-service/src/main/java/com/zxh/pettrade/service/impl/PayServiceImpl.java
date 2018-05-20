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
		//ͨ���������ҿͻ�
		User user  =order.getUser();
		//ͨ���ͻ�����Ǯ��
		Wallet wallet = user.getWallet();
		//ͨ��Ǯ�������
		Float money  = wallet.getMoney();
		//�����۸�
		Float totalMoney = Float.parseFloat(total);
		if(money >= totalMoney) {
			//�������ж�����
			for(OrderItem orderItem : order.getOrderItems()) {
				Integer inventory = orderItem.getPet().getInventory();
				Pet pet = orderItem.getPet();
				pet.setInventory(inventory - orderItem.getCount());
				//���³�����
				petService.updatePet(pet);
			}
			wallet.setMoney(money - totalMoney);
			walletService.update(wallet);
			//�Ѹ���޸Ķ���״̬Ϊ2
			order.setState(2);
			//���¶�����Ϣ
			orderService.update(order);
			//֧���ɹ�����0
			return 0;
		}else {
			//֧��ʧ�ܷ���1
			return 1;
		}
	}

}
