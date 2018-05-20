package com.zxh.pettrade.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zxh.pettrade.dao.OrdersDao;
import com.zxh.pettrade.entity.OrderItem;
import com.zxh.pettrade.entity.Orders;

@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao {

	@Override
	public List<Orders> findPageByUid(Integer uid, int begin, int rows) {
		String hql = "from Orders o where o.user.uid = ? order by o.ordertime desc";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        List<Orders> list = query.setFirstResult((begin - 1) * rows).setMaxResults(rows).list();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
	}

	@Override
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from Orders o where o.user.uid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        List<Long> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
	}

	@Override
	public Orders findByOid(Integer oid) {
		String hql = "from Orders o where o.oid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, oid);
        return (Orders) query.uniqueResult();
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Orders";
        Query query = this.getCurrentSession().createQuery(hql);
        List<Long> list = query.list();
        if (list != null && list.size() > 0) {
            Integer count = list.get(0).intValue();
            return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
        }
        return 0;
	}

	@Override
	public List<Orders> findByPage(int begin, int limit) {
		String hql = "from Orders order by ordertime desc";
        Query query = this.getCurrentSession().createQuery(hql);
        return query.setFirstResult((begin - 1) * limit).setMaxResults(limit).list();
	}

	@Override
	public List<OrderItem> findOrderItem(Integer oid) {
		 String hql = "from OrderItem oi where oi.order.oid = ?";
	        Query query = this.getCurrentSession().createQuery(hql);
	        query.setParameter(0, oid);
	        List<OrderItem> list = query.list();
	        if (list != null && list.size() > 0) {
	            return list;
	        }
	        return null;
	}

}
