package cn.blake.shoa.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.UserDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User loginUser(String username) {
		String hql = "from "+User.class.getSimpleName() +" u where u.username = :name";
		Query query = getSession().createQuery(hql);
		query.setString("name",username);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();//用这个最好,这样可以避免Could not obtain transaction-synchronized Session for current thread at org.
		}
		return session;
	}

}
