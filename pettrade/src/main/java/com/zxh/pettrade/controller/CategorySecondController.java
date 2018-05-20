package com.zxh.pettrade.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zxh.pettrade.entity.CategorySecond;
import com.zxh.pettrade.entity.Categorys;
import com.zxh.pettrade.service.CategorySecondService;
import com.zxh.pettrade.service.CategorysService;

/**
 *  宠物二级类目管理
 * @author zhaoxianhai
 *
 */

@Controller
public class CategorySecondController {

	@Autowired
	private CategorySecondService categorySecondService;

	@Autowired
	private CategorysService categorysService;

	Logger logger = LoggerFactory.getLogger(CategorySecondController.class);
	/**
	 * 二级类目列表
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/listCategorySecond/{page}", method = RequestMethod.GET)
	public String listCategorySecond(@PathVariable("page") Integer page, Map<String, Object> map) {
		List<CategorySecond> categorySeconds = categorySecondService.listCategorySecond(page);
		for(CategorySecond cs : categorySeconds){
        	logger.info("二级类目名===>"+ cs.getCsName());
        }
		
		int totalPage = categorySecondService.countCategoryPage();
		map.put("categorySeconds", categorySeconds);
		map.put("curPage", page);
		map.put("totalPage", totalPage);
		return "admin/categorysecond/list";
	}

	/**
	 *  跳转到添加二级分类的界面
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/gotoAddCategorySecond")
	public String gotoAddCategorySecond(Map<String, Object> map) {
		List<Categorys> categorys = categorysService.findAll();
		for(Categorys cs : categorys){
        	logger.info("一级类目名===>"+ cs.getCname());
        }
		map.put("categorys", categorys);
		return "admin/categorysecond/add";
	}
	
	/**
	 * 添加二级分类
	 * @param csname
	 * @param cid
	 * @return
	 */
	@RequestMapping(value = "/addCategorySecond", method = RequestMethod.POST)
    public ModelAndView addCategorySecond(@RequestParam("csname") String csname, @RequestParam("cid") Integer cid) {
		logger.info("二级类目名========>"+csname);
		logger.info("一级类目id========>"+cid);
        //查找二级类目对应的一级类目id
        Categorys category = categorysService.findCategory(cid);
        //创建二级分类对象
        CategorySecond categorySecond = new CategorySecond();
        //设置一级分类和二级分类的关联
        categorySecond.setCategory(category);
        categorySecond.setCsName(csname);
        //保存对象
        categorySecondService.addCategorySecond(categorySecond);
        ModelAndView modelAndView = new ModelAndView("redirect:listCategorySecond/1");
        return modelAndView;
    }
	
	/**
	 * 跳转到修改二级分类界面
	 * @param csid
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/gotoEditCategorySecond/{csid}")
    public String gotoEditCategorySecond(@PathVariable("csid") Integer csid,
                                         Map<String, Object> map) {
        System.out.println("===" + csid);
        //查找对应的二级分类
        CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
        map.put("categorySecond", categorySecond);
        //查找一级分类集合
        List<Categorys> categorys = categorysService.findAll();
        map.put("categorys", categorys);
        return "admin/categorysecond/edit";
    }
	
	/**
	 * 更新二级分类
	 * @param csid
	 * @param csname
	 * @param cid
	 * @return
	 */
	@RequestMapping(value = "/updateCategorySecond", method = RequestMethod.POST)
    public ModelAndView updateCategorySecond(@RequestParam("csid") Integer csid, @RequestParam("csname") String csname,
                                             @RequestParam("cid") Integer cid) {
        Categorys category = categorysService.findCategory(cid);
        CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
        categorySecond.setCategory(category);
        categorySecond.setCsName(csname);
        categorySecondService.updateCategorySecond(categorySecond);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/1");
        return modelAndView;
    }
	
	/**
	 * 删除二级分类
	 * @param csid
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/deleteCategorySecond/{csid}/{page}")
    public ModelAndView deleteCategorySecond(@PathVariable("csid") Integer csid, @PathVariable("page") Integer page) {
		categorySecondService.deleteCategorySecond(csid);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/" + page);
        return modelAndView;
    }


}
