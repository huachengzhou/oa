package cn.blake.mvc;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.blake.shoa.common.UserSessionName;
import cn.blake.shoa.domain.User;
import cn.blake.shoa.service.UserService;
import cn.blake.util.MyMD5Util;

@Controller
public class LoginController {
	private  final Log logger = LogFactory.getLog(this.getClass());
	
	@Qualifier("userService")
	@Autowired
	private UserService userService;

	/**
	 * @see 登陆
	 * @param username
	 * @param password
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(@RequestParam String username,@RequestParam String password,HttpServletRequest request,Model model) {
		boolean flag = false;
		User user = null;
		try {
		user = userService.loginUser(username);// 取出User
			if (user != null) {
				flag = MyMD5Util.validPassword(password, user.getPassword());// 进行比较(数据库保存的是md5样式)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			logger.info("登陆成功!");
			request.getSession().setAttribute(UserSessionName.USER_SESSION,user);
			return "frame/index";
		} else {
			logger.info("登陆失败!");
			model.addAttribute("error","登陆失败!");
			model.addAttribute("user", new User());
			return "system/login/login";
		}
	}

	/**
	 * @see 登陆转发
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login_")
	public String login_(Model model) {
		logger.info("login_() ");
		model.addAttribute("user", new User());
		return "system/login/login";
	}
	
	/**
	 * @see 退出登陆
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		logger.info("logout() ");
		request.getSession().removeAttribute(UserSessionName.USER_SESSION);
		return "system/login/logout";
	}
}
