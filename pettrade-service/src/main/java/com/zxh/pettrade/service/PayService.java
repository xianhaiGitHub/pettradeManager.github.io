package com.zxh.pettrade.service;

import com.zxh.pettrade.entity.Orders;

/**
 * ֧������ӿ�
 * @author zhaoxianhai
 *
 */
public interface PayService {
	/**
	 * Ǯ��֧��
	 * @param order
	 * @param addr
	 * @param name
	 * @param phone
	 * @param total
	 * @return
	 */
	int payOrderByWallet(Orders order, String addr, String name, String phone, String total);
}
