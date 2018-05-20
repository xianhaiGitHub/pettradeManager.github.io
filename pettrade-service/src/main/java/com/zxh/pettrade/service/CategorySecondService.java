package com.zxh.pettrade.service;

import java.util.List;

import com.zxh.pettrade.entity.CategorySecond;

/**
 * 二级类目服务层接口
 * 
 * @author zhaoxianhai
 *
 */
public interface CategorySecondService {

	/**
	 * 查询一级分类的页数
	 */
	Integer countCategoryPage();

	/**
	 * 分页显示二级类目
	 * 
	 * @param page
	 * @return
	 */
	List<CategorySecond> listCategorySecond(Integer page);

	/**
	 * 保存二级分类
	 * 
	 * @param categorySecond
	 */
	void addCategorySecond(CategorySecond categorySecond);

	/**
	 * 查找具体某个二级分类
	 */
	CategorySecond findCategorySecond(Integer csid);

	/**
	 * 更新二级分类
	 */
	void updateCategorySecond(CategorySecond categorySecond);

	/**
	 * 删除二级分类
	 */
	void deleteCategorySecond(Integer csid);

	/**
	 * 获取所有的二级类目
	 */
	List<CategorySecond> listCategorySecond();

}
