package com.zxh.pettrade.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 实现常用方法的基础类接口
 * T : 泛型  : 可代表所有的实体类对象，也就是表对象
 * @param <T>
 */
public interface BaseDao<T> {
	
	/**
	 * 保存 insert
	 */
	 Serializable save(T o);
	
	/**
	 * 删除delete 按id
	 */
	 void delete(Serializable id);
	
	/**
	 * 删除delete 按class
	 */
	 void delete(T o);
	
	/**
	 * 修改
	 */
	 void update(T o);
	
	/**
	 * saveOrUpdate
	 */
	 void saveOrUpdate(T o);
	
	/**
	 * 获取单个对象
	 */
	 T get(Serializable id);
	
	/**
	 * 获取数组
	 */
	 List<T> find(String hql);
	
	/**
	 * 获取数组
	 */
	 List<T> find(String hql, Map<String, Object> params);
	
	/**
	 * 获取数组分页
	 */
	 List<T> find(String hql, int page, int rows);
	
	/**
	 * 获取数组分页
	 */
	 List<T> find(String hql, Map<String, Object> params, int page, int rows);
	
	/**
	 * 获取记录数量
	 */
	 Integer count(String hql);
	
	/**
	 * 获取记录数量
	 */
	 Integer count(String hql, Integer id);
	
	/**
	 * 获取记录数量
	 */
	 Integer count(String hql, Map<String, Object> params);
	
	/**
	 * 一些特殊的DML，如特殊的修改
	 */
	 int executeHql(String hql);
	
	/**
	 * 一些特殊的DML，如特殊的修改
	 */
	 int executeHql(String hql, Map<String, Object> params);
	

}
