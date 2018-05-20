package com.zxh.pettrade.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.pettrade.entity.User;
import com.zxh.pettrade.service.UserService;

/**
 * 客户控制层
 * @author zhaoxianhai
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * 客户注册
	 * @param user
	 * @param checkcode
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String  userRegist(User user, String checkcode, HttpSession session, Map<String,Object> map) {
		logger.info("use====>" + user);
		logger.info("用户输入的验证码====>" + checkcode);
		String checkCode = (String) session.getAttribute("checkcode");
		logger.info("后台中的验证码====>" + checkCode);
		//判断验证码是否一致,不一致直接返回
		if(!checkCode.equalsIgnoreCase(checkcode)) {
			map.put("errorCheckCode", "errorCheckCode");
			return "regist";
		}
		//客户注册
		userService.registerUser(user);
		map.put("registersuccess", user.getUserName() + "注册成功,请登录");
		return "login";
	}
	/**
	 * ajax判断客户是否被注册
	 * @param userName
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/checkUser/{userName}", method=RequestMethod.POST)
	@ResponseBody
	public String exitUser(@PathVariable("userName") String userName,HttpServletResponse response) throws IOException {
		response.setContentType("text/html,charset=UTF-8");
		if(userService.existUser(userName) !=null) {
			//客户已存在
			response.getWriter().println("1");
		}else {
			//客户不存在
			response.getWriter().println("0");
		}
		return null;
	}
	/**
	 * 客户登录
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String  userLogin(User user,String checkcode, HttpSession session,Map<String, Object> map) {
		logger.info("用户输入的验证码======>"+checkcode);
		logger.info("User======>"+user);
		String checkCode = (String) session.getAttribute("checkcode");
		logger.info("后台中的验证码====>" + checkCode);
		//判断验证码是否一致,不一致直接返回
		if(!checkCode.equalsIgnoreCase(checkcode)) {
			map.put("errorCheckCode", "errorCheckCode");
			return "login";
		}
		//判断是否存此客户
		User existUser1 = userService.existUser(user.getUserName());
		if(existUser1 == null) {
			map.put("noExistuser", "noExistuser");
			return "login";
		}else {
			//判断用户名和密码
			User existUser = userService.findByUserNameAndPassword(user);
			if(existUser == null) {
				map.put("errorPassword", "errorPassword");
				return "login";
			}
			//把客户存到session中
			session.setAttribute("user", existUser);
			logger.info("session=======>" + session.getAttribute("user"));
		}
		return "redirect:index";
	}
	/**
	 * 客户退出登陆
	 * 
	 */
	@RequestMapping(value="/exit")
	public String  exitLogin(HttpSession session) {
		//销毁session
		session.invalidate();
		return "redirect:index";
	}
	
}
