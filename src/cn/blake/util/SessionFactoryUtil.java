package cn.blake.util;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SessionFactoryUtil {
	public static ApplicationContext getCtx(){
		return new ClassPathXmlApplicationContext("classpath:beans.xml");
	}
    public static SessionFactory getSessionFactory(){
    	@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
    	SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
    	return sessionFactory;
    }
    public static void transactionUtil(org.hibernate.Session session){
    	org.hibernate.Transaction transaction = session.beginTransaction();
    	transaction.commit();
    }
}
