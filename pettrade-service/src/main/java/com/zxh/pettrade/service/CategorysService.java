package com.zxh.pettrade.service;

import java.util.List;

import com.zxh.pettrade.entity.Categorys;

/**
 * 一级类目服务层接口
 * @author zhaoxianhai
 *
 */
public interface CategorysService {

	/**
	 * 查询一级分类的页数
	 */
	Integer countCategory();

	/**
	 * 当前页一级类目列表
	 */
	List<Categorys> listCategory(Integer page);

	/**
	 * 添加一级分类
	 */
	void addCategory(Categorys category);

	/**
	 * 查询某个具体的一级分类
	 */
	Categorys findCategory(Integer cid);

	/**
	 * 更新一级分类
	 */
	void updateCategory(Categorys category);

	/**
	 * 删除一级分类
	 */
	void deleteCategory(Integer cid);
	
	/**
	 * 列出所有一级分类
	 */
	List<Categorys> findAll();
}
