package com.zxh.pettrade.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxh.pettrade.entity.Pet;
import com.zxh.pettrade.service.PetService;

/**
 * 宠物分类显示管理控制层
 * @author zhaoxianhai
 *
 */
@Controller
public class PetSortManagement {
	
	@Autowired
	private PetService petService;
	
	/**
	 * 点击一级分类查询宠物
	 * @param cid
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/fingdByCid/{cid}/{page}")
	public String findByCid(@PathVariable("cid") Integer cid, @PathVariable("page") Integer page, Map<String, Object> map) {
		/**
		 * 当前页的宠物pets
		 */
		List<Pet> pets = petService.findByCid(cid, page);
		
		/**
		 * 根据一级类目cid查询总页数
		 */
		Integer count = petService.CountPagePetFromCategory(cid);
		map.put("pets", pets);
		map.put("currPage", page);
		map.put("totalPage", count);
		map.put("cid", cid);
		return "petList";
	}
	/**
	 *  点击二级分类查询宠物
	 * @param csid
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/fingdByCsid/{csid}/{page}")
	public String findByCsid(@PathVariable("csid") Integer csid, @PathVariable("page") Integer page
            , Map<String, Object> map) {
		/**
		 * 当前页的宠物pets
		 */
		List<Pet> pets = petService.findByCsid(csid, page);
		/**
		 * 根据二级类目csid查询总页数
		 */
		Integer count = petService.CountPagePetFromCategorySecondCsid(csid);
		map.put("pets", pets);
		map.put("currPage", page);
		map.put("totalPage", count);
		map.put("csid", csid);
		return "petList";
	}
	
	
	/**
	 * 根据宠物的pid查询宠物
	 * @param pid
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/findByPid/{pid}")
    public String findByPid(@PathVariable("pid") Integer pid, Map<String, Object> map) {
		Pet pet = petService.getPet(pid);
		map.put("pet", pet);
		return "pet";
	}
	
	
}
