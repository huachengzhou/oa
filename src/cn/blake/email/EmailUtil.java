package cn.blake.email;

import java.util.Map;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;


/**
 * QQ邮箱发送步骤
 * 
 * @author Blake.Zhou
 *
 */
public class EmailUtil {
	/**
	 * QQ 用户名和授权码
	 */
	private static Map<String, String> map_QQ = EmailSend.getMap("noatnu@foxmail.com", "ixqdvlqvcftihcij");
	/**
	 * 163用户名和授权码
	 */
	private static Map<String, String> map_163 = EmailSend.getMap("noatnu@163.com", "347191noatnu");

	/**
	 * 
	 * @param emails example:{ "noatnu@163.com", "347191236@qq.com"}
	 * @param hostName example:qq and 163
	 * @param title
	 * @param theme
	 * @param content
	 */
	public void emailUtil(String[] emails, String hostName, String title, String theme, String content)
			{
		if (hostName.equals("qq")) {
			try {
				testQQ(emails, hostName, title, theme, content);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (hostName.equals("163")) {
			try {
				test163(emails, hostName, title, theme, content);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void testQQ(String[] emails, String hostName, String title, String theme, String content) throws Exception {
		Session session = EmailSend.getSession(hostName);
		session.setDebug(true);
		for (int i = 0; i < emails.length; i++) {
			MimeMessage message = EmailMimeMessage.getMimeMessageUtil(session, map_QQ.get("name"), emails[i], title,
					theme, content);
			EmailSend.sendTransport(map_QQ, session, message);
		}
	}

	private void test163(String[] emails, String hostName, String title, String theme, String content)
			throws Exception {
		Session session = EmailSend.getSession(hostName);
		session.setDebug(true);
		for (int i = 0; i < emails.length; i++) {
			MimeMessage message = EmailMimeMessage.getMimeMessageUtil(session, map_163.get("name"), emails[i], title,
					theme, content);
			EmailSend.sendTransport(map_163, session, message);
		}
	}

}
