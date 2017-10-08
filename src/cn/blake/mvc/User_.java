package cn.blake.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.blake.util.CalendarUtil;

/**
 * http://localhost:9090/SpringMVCHibernate/
 */
@Controller
public class User_ {

	@RequestMapping(value = "/user_test")
	public ModelAndView user_test(ModelAndView mv) {
		String time = CalendarUtil.time();
		System.out.println("user_test");
		mv.addObject("time", time);
		mv.setViewName("test_/test_");
		return mv;
	}
}
