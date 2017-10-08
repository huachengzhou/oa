package cn.blake.email;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * 重构发送步骤
 */
public class EmailSend {
	/**
	 * smtp.qq.comQQ服务器
	 * smtp.163.com163服务器
	 */

	/**
	 * 参数配置 SMTP服务器地址参数传入hostName如qq and 163()
	 * 
	 * @param hostName
	 * @return
	 */
	private static Properties getProperties(String hostName) {
		String hostServlet = "smtp." + hostName + ".com";
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", hostServlet); // 发件人的邮箱的 SMTP服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		return props;
	}

	/**
	 * @see 获取会话(如var=qq)
	 * @param hostName
	 * @return
	 */
	public static Session getSession(String hostName) {
		return Session.getDefaultInstance(EmailSend.getProperties(hostName));
	}

	/**
	 * @see 依次传入发件人:邮箱名,密码(key:name,password)
	 * @param myEmailAccount
	 * @param myEmailPassword
	 * @return
	 */
	public static Map<String, String> getMap(String myEmailAccount, String myEmailPassword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", myEmailAccount);
		map.put("password", myEmailPassword);
		return map;
	}

	public static void sendTransport(Map<String, String> map, Session session, MimeMessage message) throws Exception {
		Map<String, String> m = map;
		String myEmailAccount = m.get("name");
		String myEmailPassword = m.get("password");
		Transport transport = session.getTransport();
		// 5使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		transport.connect(myEmailAccount, myEmailPassword);
		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients()
		// 获取到的是在创建邮件对象时添加的所有收件人,抄送人, 密送人
		transport.sendMessage(message, message.getAllRecipients());
		// 7. 关闭连接
		transport.close();
	}

}
