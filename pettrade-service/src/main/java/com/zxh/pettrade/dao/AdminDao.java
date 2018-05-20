package com.zxh.pettrade.dao;

import com.zxh.pettrade.entity.Admin;

/**
 * 系统用户dao类接口
 * @author zhaoxianhai
 *
 */
public interface AdminDao extends BaseDao<Admin> {
	
	 Admin findByUsernameAndPassword(String username,String password);
	/**
	 * 通过管理员id查找管理员
	 * @param uid
	 * @return
	 */
	 Admin findOne(Integer uid);
}
