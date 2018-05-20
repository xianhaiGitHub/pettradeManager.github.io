package com.zxh.pettrade.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.PetDao;
import com.zxh.pettrade.entity.Pet;

/**
 * 宠物接口实现类
 * 
 * @author zhaoxianhai
 *
 */
@Repository("petDao")
@Transactional
public class PetDaoImpl extends BaseDaoImpl<Pet> implements PetDao {
	final String selectHql = "select p.pid, p.image, p.isHot," + "p.markPrice, p.pdate, p.pdesc, p.pname, p.shopPrice ";

	@Override
	public Integer countPetPage() {
		String hql = "select count(*) from Pet";
		return count(hql);
	}

	@Override
	public List<Pet> findAll(Integer page) {
		String hql = "from Pet";
		int rows = 10;
		// int page1 = page;
		return find(hql, page, rows);
	}

	@Override
	public List<Pet> fintMostNew() {
		String hql = "from Pet p ";
		hql += "order by p.pdate desc ";
		int rows = 10;
		return find(hql, 1, rows);
	}

	@Override
	public List<Pet> findMostHot() {
		String hql = "from Pet p where p.isHot = 1";
		hql += "order by p.pdate desc ";
		int rows = 10;
		return find(hql, 1, rows);
	}

	@Override
	public List<Pet> findByCategoryId(Integer cid, Integer page) {
		String hql = selectHql + " from Pet p, Categorys c, CategorySecond cs ";
		hql += "where p.categorySecond = cs.csId and cs.category.cid = c.cid and c.cid = ?";
		return Query(cid, page, hql);
	}

	private List<Pet> Query(Integer cid, Integer page, String hql) {
		int rows = 12;
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, cid);
		List list = query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		List<Pet> pets = new ArrayList<Pet>();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			Pet pet = new Pet();
			int pid = (Integer) obj[0];
			pet.setPid(pid);
			pet.setImage((String) obj[1]);
			pet.setIsHot((Integer) obj[2]);
			pet.setMarkPrice((Float) obj[3]);
			pet.setPdate((Date) obj[4]);
			pet.setPdesc((String) obj[5]);
			pet.setPname((String) obj[6]);
			pet.setShopPrice((Float) obj[7]);
			pets.add(pet);
		}
		return pets;
	}

	@Override
	public Integer CountPagePetFromCategory(Integer cid) {
		String hql = "select count(*) from Pet p, Categorys c, CategorySecond cs ";
		hql += "where p.categorySecond.csId = cs.csId and cs.category.cid = c.cid and c.cid = ?";
		return count(hql, cid);
	}

	@Override
	public List<Pet> findByCategorySecondCsid(Integer csid, Integer page) {
		String hql = selectHql + "from Pet p ,CategorySecond cs ";
        hql += "where p.categorySecond.csId = cs.csId and cs.csId = ?";
        return Query(csid, page, hql);
	}

	@Override
	public Integer CountPagePetFromCategorySecondCsid(Integer csid) {
		String hql = "select count(*) from Pet p ,CategorySecond cs ";
        hql += "where p.categorySecond.csId = cs.csId and cs.csId = ?";
        return count(hql, csid);
	}
}
