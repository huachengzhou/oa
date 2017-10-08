package cn.blake.mvc;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blake.shoa.domain.Menuitem;
import cn.blake.shoa.service.MenuitemService;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * øÁ”Úò‰
 * http://localhost:8080/oa/tree.html
 * http://urchin.lstat.youku.com:8080/oa/tree.html
 * @author Blake.Zhou
 *
 */
@Controller
public class MenuitemController {
	private static final Log logger = LogFactory
			.getLog(MenuitemController.class);
	@Autowired
	private MenuitemService menuitemService;

	/**
	 * @see Ajax JSONP øÁ”Ú get
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/isMenuitemXX", method = RequestMethod.GET)
	public void isMenuitemXX(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		Collection<Menuitem> collection = menuitemService.getAllMenuitem();
		ArrayList<Menuitem> list = new ArrayList<Menuitem>(collection);
		logger.info(collection);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		String callbackName = request.getParameter("callbackParam");
		logger.info("isMenuitemXX() " + "øÁ”Ú!"+"var:"+callbackName);
		try {
			PrintWriter out = response.getWriter();
			jsonString = mapper.writeValueAsString(list);
			out.write(callbackName + "(" + jsonString + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
