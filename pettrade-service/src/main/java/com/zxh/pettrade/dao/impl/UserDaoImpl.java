package com.zxh.pettrade.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zxh.pettrade.dao.UserDao;
import com.zxh.pettrade.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByUserName(String userName) {
		String hql = "from User u where u.userName = :username";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter("username", userName);
		return (User) query.uniqueResult();
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		String hql = "from User u where u.userName = :username and u.password = :password";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		return (User) query.uniqueResult();
	}


	@Override
	public Integer countUser() {
		 String hql = "select count(*) from User";
	     return count(hql);
	}

	@Override
	public List<User> findAll(Integer page) {
		String hql = "from User";
		int rows = 10;
		int page1 = page;
		return find(hql, page1, rows);
	}

	@Override
	public User findOne(Integer uid) {
		String hql = "from User u where u.uid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        return (User) query.uniqueResult();
	}
	@Override
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
