package com.zxh.pettrade.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.OrdersDao;
import com.zxh.pettrade.entity.Orders;
import com.zxh.pettrade.service.AdminOrderService;

/**
 * 后台订单处理服务层
 * @author zhaoxianhai
 * 2018-3-21
 *
 */
@Transactional
@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService {

    @Resource
    private OrdersDao ordersDao;

    public Integer countOrder() {
        Integer count = ordersDao.findCount();
        return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
    }

    public Orders findOrder(Integer oid) {
        return ordersDao.findByOid(oid);
    }

    public List<Orders> listOrder(Integer page, Integer rows) {
        return ordersDao.findByPage(page, rows);
    }

    public void saveOrUpdateOrder(Orders order) {
        ordersDao.saveOrUpdate(order);
    }

    public void deleteOrder(Orders order) {
        ordersDao.delete(order);
    }

}
