package com.zxh.pettrade.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zxh.pettrade.dao.CategorysDao;
import com.zxh.pettrade.entity.Categorys;

@Repository("categoryDao")
public class CategorysDaoImpl extends BaseDaoImpl<Categorys> implements CategorysDao {

	@Override
	public Integer countCategory() {
		String hql = "select count(*) from Categorys";
		return count(hql);
	}

	@Override
	public List<Categorys> findAll(Integer page) {
		String hql = "from Categorys";
        int rows = 10;
        return find(hql, page, rows);
	}

	@Override
	public List<Categorys> findAll() {
		String hql = "from Categorys";
		return find(hql);
	}


}
