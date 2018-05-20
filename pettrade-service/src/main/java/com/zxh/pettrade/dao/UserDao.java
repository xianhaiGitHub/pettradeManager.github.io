package com.zxh.pettrade.dao;

import java.util.List;

import com.zxh.pettrade.entity.User;

/**
 *  客户的Dao接口
 * @author zhaoxianhai
 *
 */
 
public interface UserDao extends BaseDao<User>{
	/**
	 * 查询用户名
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);
	
	/**
	 * 通过用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User findByUserNameAndPassword(String userName,String password);
	
	 /**
     * 根据激活码查询用户
     *
     * @param code
     * @return
     */
     User findByCode(String code);

    /**
     * 查询有多少个用户
     *
     * @return
     */
     Integer countUser();

    /**
     * 分页查找所有用户
     *
     * @param page
     * @return
     */
     List<User> findAll(Integer page);

    /**
     * 查找单个用户
     *
     * @param uid
     * @return
     */
     User findOne(Integer uid);


}
