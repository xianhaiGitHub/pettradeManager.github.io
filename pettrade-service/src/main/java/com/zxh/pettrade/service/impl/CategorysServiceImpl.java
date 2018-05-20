package com.zxh.pettrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.CategorysDao;
import com.zxh.pettrade.entity.Categorys;
import com.zxh.pettrade.service.CategorysService;

/**
 * 一级类目服务层实现
 * @author zhaoxianhai
 *
 */
@Service("categorysService")
@Transactional
public class CategorysServiceImpl implements CategorysService{
	
	@Autowired
	private CategorysDao categorysDao;

	/**
	 * 查询一级分类的页数
	 */
	@Override
	public Integer countCategory() {
		Integer count = categorysDao.countCategory();
		/**
		 * 从总数得到出总页数
		 */
        return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
	}

	/**
	 * 当前页一级类目列表
	 */
	@Override
	public List<Categorys> listCategory(Integer page) {
		return categorysDao.findAll(page);
	}

	@Override
	public void addCategory(Categorys category) {
		categorysDao.save(category);
	}

	@Override
	public Categorys findCategory(Integer cid) {
		return categorysDao.get(cid);
	}

	@Override
	public void updateCategory(Categorys category) {
		categorysDao.update(category);
	}

	@Override
	public void deleteCategory(Integer cid) {
		categorysDao.delete(cid);
	}

	@Override
	public List<Categorys> findAll() {
		return categorysDao.findAll();
	}

}
