package cn.blake.util;

import java.io.UnsupportedEncodingException;
/**
 * 
 * @author Blake.Zhou
 *
 */
public class UTF_8Utils {
	public static String getUTF_8(String str) {
		try {
			/**
			 * ∑≠“Î≥…¬Î±Ì
			 */
			byte[] buf = str.getBytes("ISO8859-1");
			/**
			 * Ω‚¬Î
			 */
			str = new String(buf, "UTF-8").toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
