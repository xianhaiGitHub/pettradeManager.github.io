package com.zxh.pettrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.OrdersDao;
import com.zxh.pettrade.entity.Orders;
import com.zxh.pettrade.service.OrderService;

@Service("orderService")
@Transactional
public class OrdeServiceImpl implements OrderService {

	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void save(Orders order) {
		ordersDao.save(order);
	}

	@Override
	public Orders findByOid(Integer oid) {
		return ordersDao.get(oid);
	}

	@Override
	public void update(Orders order) {
		ordersDao.update(order);
	}

	@Override
	public Integer findCountByUid(Integer uid) {
		Integer count = ordersDao.findCountByUid(uid);
		return (count % 6 == 0 ? (count / 6) : (count % 6 + 1));
	}

	@Override
	public List<Orders> findByUid(Integer uid, Integer page) {
		// Ã¿Ò³·Å6ÐÐ
		int rows = 6;
		return ordersDao.findPageByUid(uid, page, rows);
	}

}
