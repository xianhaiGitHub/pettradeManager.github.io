package com.zxh.pettrade.dao;

import java.util.List;

import com.zxh.pettrade.entity.Categorys;



/**
 *  一级类目的Dao接口
 * @author zhaoxianhai
 *
 */
 
public interface CategorysDao extends BaseDao<Categorys> {

	/**
	 * 一级类目总数
	 * @return
	 */
	 Integer countCategory();
	 
	 /**
	  * 分页查找一级类目
	  * @param page
	  * @return
	  */
	List<Categorys> findAll(Integer page);
	 
	 
	List<Categorys> findAll();
}
