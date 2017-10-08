package cn.blake.email;

import java.util.Date;
import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 * 非xml 方式(动态Util)
 * @author Blake.Zhou
 */
public class SpringEmail_Util {
    public static void main(String[] args) {
		String[] to = {"noatnu@163.com","347191236@qq.com","noatnu@foxmail.com","noatnu@gmail.com"};
		String theme = "淘宝网";
		String content = "夏季大甩卖--------------->快来选购";
		String formEmail = "noatnu@163.com";
		String password = "347191noatnu";
		SpringEmail_Util.emailUtil(to, formEmail, password, theme, content);
	}
    /**
     * 
     * @param to  email[]
     * @param formEmail example:xxx@xx.com
     * @param password  *******
     * @param theme   write book
     * @param content  word
     */
    public static void emailUtil(String[] to,String formEmail,String password,String theme,String content){
    	SimpleMailMessage mailMessage = emailMessage(formEmail, theme, content);
    	emailSender(mailMessage, to, formEmail, password);
    	System.out.println("email send ok!");
    }
	private static void emailSender(SimpleMailMessage mailMessage,String[] to,String formEmail,String password) {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		String hostName = formEmail.substring(formEmail.lastIndexOf("@")+1,formEmail.lastIndexOf("."));
		senderImpl.setHost("smtp."+hostName+".com");// 设定smtp邮件服务器
		String username = formEmail.substring(0, formEmail.lastIndexOf("@"));
		senderImpl.setUsername(username); 
		senderImpl.setPassword(password);
		Properties prop = new Properties();
		prop.put(" mail.smtp.auth ", " true "); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put(" mail.smtp.timeout ", " 25000 ");
		senderImpl.setJavaMailProperties(prop);
		mailMessage.setTo(to);
		senderImpl.send(mailMessage);
	}

	private static SimpleMailMessage emailMessage(String formEmail,String theme,String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(formEmail);
		mailMessage.setSubject(theme);
		mailMessage.setText(content);
		mailMessage.setSentDate(new Date());
		return mailMessage;
	}
}
