package cn.blake.mvc;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {
	private static final Log logger = LogFactory.getLog(ProductController.class);

	@RequestMapping(value = "/product_save")
	public String product_save(HttpServletRequest request, Model model, @RequestParam("file") MultipartFile file) {
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		product.setImage(file);
		if (!file.isEmpty()) {// 文件不为null
			String path = request.getServletContext().getRealPath("/image/");// 上传路径
			String fileName = file.getOriginalFilename();// 文件名
			File filepath = new File(path, fileName);
			logger.debug("file:"+file + " fileName:" + fileName + " filepath:" + filepath + " product:" + product);
			// 判断路径是否存在如果不存在则创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件中
			try {
				file.transferTo(new File(path + File.separator + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("product", product);
		return "test_/productDetails";
	}

	/**
	 * @see 跳转到上传文件页面
	 * @param mv
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/product_input")
	public String product_input(Model model) {
		model.addAttribute("product", new Product());
		logger.info("start!");
		System.out.println("/product_input()");
		return "test_/productForm";
	}
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("fileName") String fileName,Model model){
		String path = request.getServletContext().getRealPath("/image/");
		File file = new File(path+File.separator+fileName);
		HttpHeaders headers = new HttpHeaders();
		logger.debug("文件开始下载!");
		//解决下载显示的文件名问题
		try {
			String downloadFileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
			//通知浏览器以下载的方式打开图片
			headers.setContentDispositionFormData("attachment",downloadFileName);
			//二进制流数据(最常见的文件下载)
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			logger.debug("成功!");
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
