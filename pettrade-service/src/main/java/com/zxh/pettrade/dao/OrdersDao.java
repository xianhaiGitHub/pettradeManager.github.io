package com.zxh.pettrade.dao;

import java.util.List;

import com.zxh.pettrade.entity.OrderItem;
import com.zxh.pettrade.entity.Orders;

/**
 * 订单的Dao接口
 * 
 * @author zhaoxianhai
 *
 */
public interface OrdersDao extends BaseDao<Orders> {
	/**
	 * Dao层查询我的订单分页查询:查询数据
	 */
	List<Orders> findPageByUid(Integer uid, int begin, int rows);

	/**
	 * Dao层查询我的订单分页查询:统计个数
	 */
	int findCountByUid(Integer uid);
	
	 /**
     * DAO层根据订单id查询订单
     *
     * @param oid
     * @return
     */
    Orders findByOid(Integer oid);

    /**
     * DAO中统计订单个数的方法
     *
     * @return
     */
     int findCount();

    /**
     * DAO中分页查询订单的方法
     *
     * @param begin
     * @param limit
     * @return
     */
     List<Orders> findByPage(int begin, int limit);

    /**
     * DAo中根据订单id查询订单项
     *
     * @param oid
     * @return
     */
    List<OrderItem> findOrderItem(Integer oid);

}
