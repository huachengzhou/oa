package test.n1;

import org.hibernate.Session;
import org.junit.Test;

import cn.blake.util.SessionFactoryUtil;


public class SessionFactoryTest {
	Session session = SessionFactoryUtil.getSessionFactory().openSession();
	@Test
	public void sessionTest(){
		System.out.println(session);
	}
}
