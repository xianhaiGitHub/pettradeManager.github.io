package com.zxh.pettrade.dao;

import java.util.List;

import com.zxh.pettrade.entity.CategorySecond;


/**
 * 二级类目的Dao接口
 * @author zhaoxianhai
 *
 */
public interface CategorySecondDao extends BaseDao<CategorySecond> {

	/**
     * 查询二级分类的总的个数
     *
     * @return
     */
    Integer countCategorySecond();

    /**
     * 分页查找所有二级分类
     *
     * @param page
     * @return
     */
     List<CategorySecond> findAll(Integer page);
    
    
    /**
     * 获取所有的二级类目
     */
     List<CategorySecond> findAll();
    
}
