package cn.blake.shoa.InterceptorAndException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * @see 统一处理异常
 * @author Blake.Zhou
 */
@SuppressWarnings("serial")
@ControllerAdvice
public class AppWideExceptionHandler extends Exception {
	private static final Log logger = LogFactory.getLog(AppWideExceptionHandler.class);
	
	@ExceptionHandler(value = {NoSuchRequestHandlingMethodException.class})
	public String appNoSuchRequestHandling(Model model, Exception ex) {
		logger.info("----> 出异常了: " + ex);
		model.addAttribute("error",ex.getMessage());
		return "exception/404";
	}
	@ExceptionHandler(value = {HttpMessageNotWritableException.class})
	public String appHttp(Model model, Exception ex) {
		logger.info("----> 出异常了: " + ex);
		model.addAttribute("error",ex.getMessage());
		return "exception/500";
	}
}
