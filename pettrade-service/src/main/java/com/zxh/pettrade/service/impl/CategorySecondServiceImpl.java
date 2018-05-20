package com.zxh.pettrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.CategorySecondDao;
import com.zxh.pettrade.entity.CategorySecond;
import com.zxh.pettrade.service.CategorySecondService;

/**
 * 二级类目service层
 * @author zhaoxianhai
 *
 */
@Transactional
@Service("categorySecondService")
public class CategorySecondServiceImpl implements CategorySecondService {
	
	@Autowired
	 private CategorySecondDao categorySecondDao;

	@Override
	public Integer countCategoryPage() {
		Integer count = categorySecondDao.countCategorySecond();
        return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
	}

	@Override
	public List<CategorySecond> listCategorySecond(Integer page) {
		return categorySecondDao.findAll(page);
	}

	@Override
	public void addCategorySecond(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	@Override
	public CategorySecond findCategorySecond(Integer csid) {
		return categorySecondDao.get(csid);
	}

	@Override
	public void updateCategorySecond(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	@Override
	public void deleteCategorySecond(Integer csid) {
		categorySecondDao.delete(csid);
	}

	@Override
	public List<CategorySecond> listCategorySecond() {
		return categorySecondDao.findAll();
	}

}
