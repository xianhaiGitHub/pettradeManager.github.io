package com.zxh.pettrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.AdminDao;
import com.zxh.pettrade.dao.UserDao;
import com.zxh.pettrade.entity.Admin;
import com.zxh.pettrade.entity.User;
import com.zxh.pettrade.service.AdminService;

/**
 * 系统管理员service层
 * @author zhaoxianhai
 * 2018-3-1
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private UserDao userDao;
	/**
	 *根据用户名和密码 查询用户
	 */
	@Override
	public Admin checkUser(Admin admin) {
		return adminDao.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(Integer uid) {
		userDao.delete(uid);
	}
	/**
	 * 查询所有的客户
	 */
	@Override
	public List<User> findUser(Integer page) {
		return userDao.findAll(page);
	}
	/**每页显示10条数据
	 * 计算有多少页的客户
	 */
	@Override
	public Integer countUser() {
		Integer count = userDao.countUser();
		return (count % 10 == 0 ? (count / 10) : (count / 10 +1));
	}
	
	/**
	 * 查询客户
	 */
	@Override
	public User findUserByUid(Integer uid) {
		return userDao.findOne(uid);
	}
	/**
	 * 根据管理员的uid查询管理员信息
	 */
	@Override
	public Admin findAdminByAid(Integer uid) {
		adminDao.findOne(uid);
		return null;
	}
	

	

}
