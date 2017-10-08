package cn.blake.shoa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public void saveEntry(T t) {
		getSession().save(t);
	}

	public void updateEntry(T t) {
		getSession().update(t);
	}

	public void deleteEntry(Serializable id, Class<T> entityClass) {
		T t = (T) getSession().get(entityClass.getClass(), id);
		getSession().delete(t);
	}

	public T getEntryById(Serializable id, Class<T> entityClass) {
		T t = (T) getSession().get(entityClass, id);
		return t;
	}

	public Collection<T> getAllEntry(Class<T> entityClass) {
		String hql = "FROM "+entityClass.getSimpleName();
		Query query = getSession().createQuery(hql);
		List<T> list = query.list();
		return list;
	}

	public Set<T> getEntrysByIDS(String idType, String ids, Class<T> entityClass) {
		String hql = "FROM "+entityClass.getSimpleName()+" e where "+idType+" in("+ids+")";
		List<T> list = getSession().createQuery(hql).list();
		Set<T> set = new HashSet<T>(list);
		return set;
	}

	public Set<T> getEntrysByIDS(String idType, Object[] ids,Class<T> entityClass) {
		String hql = "FROM "+entityClass.getSimpleName()+" e where "+idType+" in(:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids",ids);
		List<T> list = query.list();
		Set<T> set = new HashSet<T>(list);
		return set;
	}

}
