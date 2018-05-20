package com.zxh.pettrade.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zxh.pettrade.entity.Admin;
import com.zxh.pettrade.entity.User;
import com.zxh.pettrade.service.AdminService;

/**
 * admin控制层
 * @author zhaoxianhai
 *
 */
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	/**
	 * 跳至修改密码页面
	 * 
	 */
	@RequestMapping(value="/changepwd")
	public String changepwd(){
		return "admin/system/changepwd";
	}
	/**
	 * 通过uid删除当前页的客户
	 * @param uid
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/deleteUser/{uid}/{page}")
	public ModelAndView deleteUser(@PathVariable("uid") Integer uid, @PathVariable("page") Integer page){
		adminService.deleteUser(uid);
		ModelAndView model = new ModelAndView("redirect:/listUser/" + page);
		return model;
	}
	  /**
	   * 更新客户信息
	   * @param user
	   * @return
	   */
    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        adminService.updateUser(user);
        ModelAndView model = new ModelAndView("redirect:/listUser/1");
        return model;
    }
    /**
	 * 跳至修改客户页面
	 * @param uid
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/toEditUser/{uid}")
	public String editUser(@PathVariable("uid") Integer uid, @ModelAttribute("user") User user, Map<String, Object> map) {
		user = adminService.findUserByUid(uid);
		map.put("user", user);
		return "admin/user/edit";
	}
	/**
	 * admin对客户的操作
	 * 分页查询客户
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/listUser/{page}")
	public String listUser(@PathVariable("page") Integer page, Map<String, Object> map){
		/**
		 *查询客户
		 */
		List<User> userList = adminService.findUser(page);
		/**
		 * 查询页数
		 */
		Integer totalPage = adminService.countUser();
		
		map.put("page", page);
		map.put("userList", userList);
		map.put("totalPage", totalPage);
		return "admin/user/listuser";
	}
	
	/**
	 * 跳至登陆页面
	 * @return
	 */
	@RequestMapping(value="/admin")
	public String adminIndex(){
		return "admin/login";
	}
	
	/**
	 * admin登陆操作
	 * @param admin
	 * @param session
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/adminLogin", method = RequestMethod.POST)
	public String adminLogin(Admin admin, HttpSession session){
		Admin user = adminService.checkUser(admin);
		if(user == null) {
			return "admin/login";
		}else {
			/**
			 * 把admin存到session中
			 */
			session.setAttribute("admin", admin);
			return "admin/home";
		}
	}
	/**
	 * admin退出登陆
	 * @param session
	 * @return
	 */
	@RequestMapping("/adminOut")
	public String adminOut(HttpSession session){
		session.removeAttribute("admin");
		return "admin/login";
	}

	/**
	 * 顶部
	 * @return
	 */
	@RequestMapping("/adminTop")
	public String adminTop(){
		return "admin/top";
	}
	
	/**
	 * 左部
	 * @return
	 */
	@RequestMapping("/adminLeft")
	public String adminLeft(){
		return "admin/left";
	}
	
	/**
	 * 欢迎页
	 * @return
	 */
	@RequestMapping("/adminWelcome")
	public String adminWelcome(){
		return "admin/welcome";
	}
	
	/**
	 * 底部
	 * @return
	 */
	@RequestMapping("/adminBottom")
	public String adminBottom(){
		return "admin/bottom";
	}
}
