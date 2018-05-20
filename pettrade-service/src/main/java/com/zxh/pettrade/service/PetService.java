package com.zxh.pettrade.service;

import java.util.List;

import com.zxh.pettrade.entity.Pet;

/**
 * 宠物服务层接口
 * 
 * @author zhaoxianhai
 *
 */
public interface PetService {

	/**
	 * 查询宠物的页数
	 */
	Integer countPetPage();

	/**
	 * 分页显示宠物
	 * 
	 * @param page
	 * @return
	 */
	List<Pet> listPet(Integer page);

	/**
	 * 保存宠物
	 * 
	 * @param pet
	 */
	void savePet(Pet pet);

	/**
	 * 获取一个宠物
	 * 
	 * @param pet
	 */
	Pet getPet(Integer pid);

	/**
	 * 删除一个宠物
	 * 
	 * @param pet
	 */

	void deletePet(Pet pet);

	/**
	 * 更新宠物
	 * 
	 * @param pet
	 */

	void updatePet(Pet pet);

	/**
	 * 查询最新的宠物
	 * 
	 * @return
	 */
	List<Pet> fintMostNew();

	/**
	 * 查询最热的宠物
	 * 
	 * @return
	 */
	List<Pet> findMostHot();

	/**
	 *  根据一级分类查询宠物
	 * @param cid
	 * @param page
	 * @return
	 */
	 
	List<Pet> findByCid(Integer cid, Integer page);

	/**
	 * 根据一级分类查询宠物总页数
	 * @param cid
	 * @return
	 */
	
	Integer CountPagePetFromCategory(Integer cid);

	/**
	 * 根据二级分类查询宠物
	 * @param csid
	 * @param page
	 * @return
	 */

	List<Pet> findByCsid(Integer csid, Integer page);

	/**
	 * 根据二级分类查询宠物总页数
	 * @param csid
	 * @return
	 */
	 
	Integer CountPagePetFromCategorySecondCsid(Integer csid);

}
