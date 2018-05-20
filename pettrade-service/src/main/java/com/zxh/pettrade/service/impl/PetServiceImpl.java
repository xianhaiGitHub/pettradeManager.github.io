package com.zxh.pettrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.PetDao;
import com.zxh.pettrade.entity.Pet;
import com.zxh.pettrade.service.PetService;

/**
 * 宠物service层
 * @author zhaoxianhai
 *
 */
@Service("petService")
@Transactional
public class PetServiceImpl implements PetService{
	@Autowired
	private PetDao petDao;

	/**
	 * 计算总页数,每一页显示10只宠物
	 */
	@Override
	public Integer countPetPage() {
		Integer count = petDao.countPetPage();
		return (count%10 == 0?(count / 10):(count / 10 + 1));
	}
	/**
	 * 当前页所有pet
	 */
	@Override
	public List<Pet> listPet(Integer page) {
		return petDao.findAll(page);
	}
	/**
	 * 保存pet
	 */
	@Override
	public void savePet(Pet pet) {
		petDao.save(pet);
	}
	
	/**
	 * 查询一个pet
	 */
	@Override
	public Pet getPet(Integer pid) {
		return petDao.get(pid);
	}
	/**
	 * 删除pet
	 */
	@Override
	public void deletePet(Pet pet) {
		petDao.delete(pet);
	}
	/**
	 * 更新pet
	 */
	@Override
	public void updatePet(Pet pet) {
		petDao.update(pet);
	}
	/**
	 * 查询最新的宠物10只
	 */
	@Override
	public List<Pet> fintMostNew() {
		return petDao.fintMostNew();
	}
	/**
	 * 查询最热的宠物10只
	 */
	@Override
	public List<Pet> findMostHot() {
		return petDao.findMostHot();
	}
	/**
	 * 通过一级类目cid查询
	 */
	@Override
	public List<Pet> findByCid(Integer cid, Integer page) {
		return petDao.findByCategoryId(cid, page);
	}
	/**
	 * 根据一级类目查询宠物总页数并分页,每一页显示12只宠物
	 */
	@Override
	public Integer CountPagePetFromCategory(Integer cid) {
		Integer count =petDao.CountPagePetFromCategory(cid);
		return (count % 12 == 0 ? (count / 12):(count / 12 + 1));
	}
	/**
	 * 通过二级类目cid查询
	 */
	@Override
	public List<Pet> findByCsid(Integer csid, Integer page) {
		return petDao.findByCategorySecondCsid(csid, page);
	}
	
	/**
	 * 根据二级类目查询宠物总页数并分页,每一页显示12只宠物
	 */
	@Override
	public Integer CountPagePetFromCategorySecondCsid(Integer csid) {
		Integer count = petDao.CountPagePetFromCategorySecondCsid(csid);
		return (count % 12 == 0 ? (count / 12) : (count / 12 + 1));
	}
}
