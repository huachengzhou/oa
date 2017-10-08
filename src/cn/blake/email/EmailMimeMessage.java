package cn.blake.email;

import java.util.Date;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 重构创建邮件步骤
 */
public class EmailMimeMessage {
	/**
	 * 
	 * @param session
	 * @param sendMail
	 * @param email
	 * @param title
	 * @param theme
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage getMimeMessageUtil(Session session, String sendMail, String email,String title,String theme,String content) throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);
		
		// 2. From: 发件人
		message.setFrom(new InternetAddress(sendMail,title, "UTF-8"));
		
		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email, "UTF-8"));
		// 4. Subject: 邮件主题
		message.setSubject(theme, "UTF-8");
		
		// 5. Content: 邮件正文（可以使用html标签）
		message.setContent(content, "text/html;charset=UTF-8");
		
		// 6. 设置发件时间
		message.setSentDate(new Date());
		
		// 7. 保存设置
		message.saveChanges();
		return message;
	}
}
