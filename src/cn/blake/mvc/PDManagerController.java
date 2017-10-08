package cn.blake.mvc;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.blake.shoa.service.PDManager;
/**
 * 版本控制管理
 * @author Blake.Zhou
 *
 */
@Controller
public class PDManagerController {
	private static final Log logger = LogFactory.getLog(PDManagerController.class);
	@Autowired
	private PDManager pDManager;
	
	@RequestMapping(value="/showManagerImg")
	public ResponseEntity<byte[]> showManagerImg(HttpServletResponse response,@RequestParam String deploymentId) throws IOException {
		logger.info("showManagerImg "+deploymentId);
		BufferedInputStream in = new BufferedInputStream(pDManager.getImgManager(deploymentId));
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		while (in.available()!=0) {
			byteArray.write(in.read());
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		logger.info("length:"+byteArray.toByteArray().length);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(byteArray.toByteArray(),headers,HttpStatus.CREATED);
		return responseEntity;
	}
	
	/**
	 * @see 显示版本信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showLasterVersions")
	public String showLasterVersions(Model model){
		logger.info("showLasterVersions");
		Collection<ProcessDefinition> processDefinitions = new ArrayList<ProcessDefinition>();
		try {
			processDefinitions = pDManager.getLasterVersion();
		} catch (Exception e) {
			logger.debug(e.getMessage()+" "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
		}
		model.addAttribute("processDefinitions",processDefinitions);
		logger.info("data:"+processDefinitions);
		return "workflow/pdmanager/list";
	}
	
	/**
	 * @see 部署
	 * @param model
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deployManager")
	public String deployManager(Model model, @RequestParam("file") MultipartFile file) throws Exception{
		logger.info("deployManager file data:"+file.getBytes().length);
		if (!file.isEmpty()) {// 文件不为null
			InputStream inputStream = file.getInputStream();
			if (inputStream!=null) {
				try {
					pDManager.deploy(inputStream);
					logger.info("deploy Manager 成功！..........");
				} catch (Exception e) {
					System.out.println("error:--->"+e.getMessage());
					logger.debug(e.getMessage());
				}
			}
		}
		return "redirect:/showLasterVersions";
	}
	
	@RequestMapping(value="/removePDManager")
	public String removePDManager(@RequestParam String key){
		logger.info("removePDManager "+key);
		try {
			pDManager.removePD(key);
			logger.info("removePDManager success!");
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return "redirect:/showLasterVersions";
	}
	
	/**
	 * @see 转到部署页面
	 * @return
	 */
	@RequestMapping(value="/deployUI")
	public String deployUI(){
		logger.info("deployUI");
		return "workflow/pdmanager/deployUI";
	}
}
