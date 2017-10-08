package cn.blake.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @see ×ª·¢Æ÷
 * @author Blake.Zhou
 *
 */
@Controller
public class FowardController {
	private static final Log logger = LogFactory.getLog(FowardController.class);

	@RequestMapping(value = "/indexA")
	public String forword() {
		logger.info("forword()");
		return "frame/index";
	}

	@RequestMapping("/forward_top")
	public String forward_top() {
		logger.info("forward_top()");
		return "frame/top";
	}

	@RequestMapping("/forward_bottom")
	public String forward_bottom() {
		logger.info("forward_bottom()");
		return "frame/bottom";
	}

	@RequestMapping("/forward_right")
	public String forward_right() {
		logger.info("forward_right()");
		return "frame/right";
	}
	
	@RequestMapping("/forward_left")
	public String forward_left() {
		logger.info("forward_left()");
		return "frame/left";
	}
}
