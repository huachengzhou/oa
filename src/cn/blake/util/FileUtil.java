package cn.blake.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author Blake.Zhou
 *
 */
public class FileUtil {
	/**
	 * @param file
	 * @param request
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String saveFile(MultipartFile file,HttpServletRequest request){
		String url = "";
		if (!file.isEmpty()) {// 文件不为null
			String path = "";
			try {
//				path = request.getServletContext().getRealPath("/document/");// 上传路径
				path = request.getRealPath("/document/");
			} catch (Exception e) {
			}
			String fileName = file.getOriginalFilename();// 文件名
			File filepath = new File(path, fileName);
			// 判断路径是否存在如果不存在则创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件中
			try {
				url = path + File.separator + fileName;
				file.transferTo(new File(path + File.separator + fileName));
			} catch (Exception e) {
				
			}
		}
		return url;
	}
}
