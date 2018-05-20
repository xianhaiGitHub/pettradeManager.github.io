package com.zxh.pettrade.service;

import com.zxh.pettrade.entity.Orders;

/**
 * 支付服务接口
 * @author zhaoxianhai
 *
 */
public interface PayService {
	/**
	 * 钱包支付
	 * @param order
	 * @param addr
	 * @param name
	 * @param phone
	 * @param total
	 * @return
	 */
	int payOrderByWallet(Orders order, String addr, String name, String phone, String total);
}
