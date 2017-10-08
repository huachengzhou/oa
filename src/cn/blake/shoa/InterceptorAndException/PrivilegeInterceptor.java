package cn.blake.shoa.InterceptorAndException;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.blake.shoa.domain.Privilege;
import cn.blake.shoa.domain.User;
import cn.blake.shoa.service.PrivilegeService;
import cn.blake.util.SessionFactoryUtil;

public class PrivilegeInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse response, Object object, Exception ex)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object, ModelAndView mv)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean flag = false;
		if ("blake".equals(user.getUsername())) {
			flag = true;
		} else {
			/* 用户能够访问到的权限 */
			@SuppressWarnings("unchecked")
			Collection<Privilege> privileges = (Collection<Privilege>) SessionFactoryUtil.getCtx()
					.getBean(PrivilegeService.class);
			
		}
		return false;
	}

}
