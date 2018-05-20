package com.zxh.pettrade.service;

import java.util.List;

import com.zxh.pettrade.entity.Admin;
import com.zxh.pettrade.entity.User;

/**
 * admin服务层接口
 * 
 * @author zhaoxianhai
 *
 */
public interface AdminService {
	/**
	 * 检查用户
	 * 
	 * @param admin
	 * @return
	 */
	Admin checkUser(Admin admin);

	/**
	 * 修改客户信息
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 删除客户
	 * @param uid
	 */
	void deleteUser(Integer uid);

	/**
	 * 查询所有的用户
	 * @param page
	 * @return
	 */
	List<User> findUser(Integer page);

	/**
	 *  统计有多少页的用户
	 * @return
	 */
	Integer countUser();

	/**
	 * 根据用户的uid查询用户信息
	 * @param uid
	 * @return
	 */
	User findUserByUid(Integer uid);

	/**
	 * 根据管理员id查询管理员的信息
	 * @param aid
	 * @return
	 */
	Admin findAdminByAid(Integer uid);
}
