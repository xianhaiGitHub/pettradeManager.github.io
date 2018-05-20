package com.zxh.pettrade.service;

import java.util.List;

import com.zxh.pettrade.entity.Orders;

public interface AdminOrderService {

    //查询某个具体的订单
    public Orders findOrder(Integer oid);

    //保存和更新订单
    public void saveOrUpdateOrder(Orders order);

    //删除该订单
    public void deleteOrder(Orders order);

    //分页查询所有的订单
    public List<Orders> listOrder(Integer page, Integer rows);

    //查询总共有多少页的订单
    public Integer countOrder();

}
