package com.zxh.pettrade.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zxh.pettrade.dao.CategorySecondDao;
import com.zxh.pettrade.entity.CategorySecond;

@Repository("categorySecondDao")
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao {

	@Override
	public Integer countCategorySecond() {
		String hql = "select count(*) from CategorySecond";
        return count(hql);
	}

	@Override
	public List<CategorySecond> findAll(Integer page) {
		String hql = "from CategorySecond";
        int rows = 10;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return find(hql);
	}

}
