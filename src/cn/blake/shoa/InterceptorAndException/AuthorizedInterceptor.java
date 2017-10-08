package cn.blake.shoa.InterceptorAndException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.blake.shoa.domain.User;

public class AuthorizedInterceptor implements HandlerInterceptor {
	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = { "/oa/login_", "oa/login_",
			"/login_", "login_", "login", "/login", "oa/login", "/oa/login",
			"/oa/addUser_", "/getSysManageLoginCode", "/checkimagecode" };

	/**
	 * 该方法需要preHandle方法的返回值为true时才会执行。 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	/**
	 * 这个方法在preHandle方法返回值为true的时候才会执行。 执行时间是在处理器进行处理之
	 * 后，也就是在Controller的方法调用之后执行。
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		/** 默认用户没有登录 */
		boolean flag = false;
		/* 定义默认的Servlet path */
		String servletPath = request.getServletPath();
		/** 判断请求是否需要拦截 */
		for (String str : IGNORE_URI) {
			if (servletPath.contains(str)) {
				flag = true;
				break;
			}
		}
		/** 拦截请求 */
		if (!flag) {
			/** 1.获取session中的用户 */
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			/** 2:判断用户是否已经登陆 */
			if (user != null) {
				flag = true;
			} else {// 没有登录
				request.setAttribute("error", "no login");
				request.getRequestDispatcher(
						"/WEB-INF/views/system/login/login.jsp").forward(
						request, response);
			}
		}
		return flag;
	}

}
