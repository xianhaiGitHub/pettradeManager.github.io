package com.zxh.pettrade.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zxh.pettrade.entity.Categorys;
import com.zxh.pettrade.service.CategorysService;



/**
 * 宠物一级类目管理
 * @author zhaoxianhai
 *
 */

@Controller
public class CategorysController {
	
	@Autowired
	private CategorysService categorysService;
	
	/**
	 * 一级类目列表
	 */
	@RequestMapping(value = "/listCategory/{page}")
	 public String listCategorys(@PathVariable("page") Integer page, Map<String, Object> map){
		List<Categorys> categoryPage = categorysService.listCategory(page);
		map.put("categorys", categoryPage);
        map.put("page", page);
        //查询一级分类的页数
        Integer count = categorysService.countCategory();
        map.put("count", count);
		return "admin/category/list";
	 }
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(value = "/gotoAddCategory")
    public String gotoAddCategory() {
        return "admin/category/add";
    }
	
	/**
	 * 添加一级类目
	 */
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView addCategory(@RequestParam(value = "cname", required = true) String cname) {
        //创建一级分类的对象
    	Categorys category = new Categorys();
        category.setCname(cname);
        categorysService.addCategory(category);
        ModelAndView modelAndView = new ModelAndView("redirect:listCategory/1");
        return modelAndView;
    }
	/**
	 *  跳转到编辑页面
	 */
	@RequestMapping(value = "/gotoEditCategory/{cid}")
    public String gotoEditCategory(@PathVariable("cid") Integer cid, Map<String, Object> map) {
    	Categorys category = categorysService.findCategory(cid);
        map.put("category", category);
        return "admin/category/edit";
    }
	
	@ModelAttribute("category")
    public void getCategory(@RequestParam(value = "cid", required = false) Integer cid, Map<String, Object> map) {
        if (cid != null) {
            Categorys category = categorysService.findCategory(cid);
            map.put("category", category);
        }
    }
	
	/**
	 * 修改一级分类
	 */
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public ModelAndView updateCategory(@ModelAttribute("category") Categorys category) {
		categorysService.updateCategory(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategory/1");
        return modelAndView;
    }
	
	/**
	 * 删除一级分类
	 */
	@RequestMapping(value = "/deleteCategory/{cid}/{page}")
    public ModelAndView deleteCategory(@PathVariable("cid") Integer cid, @PathVariable("page") Integer page) {
		categorysService.deleteCategory(cid);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategory/" + page);
        return modelAndView;
    }

}
