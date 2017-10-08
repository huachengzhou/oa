package cn.blake.shoa.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.RoleDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Collection<Role> getRoles(Integer uid) {
		/**
		 * 1、把所有的角色全部提取出来 2、把用户能够访问到的角色提取出来 3、遍历循环所有的角色 再遍历用户能够访问到的角色
		 * 如果正在遍历的所有的角色当中的某一个角色正好是用户能够访问到的，那么设置checked为true
		 */
		Collection<Role> allRoles = getAllEntry(Role.class);
		String hql = "from Role r inner join fetch r.users u where u.uid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0,uid);
		List<Role> userRoles = query.list();
//		Collection<Role> userRoles = (Collection<Role>) hibernateTemplate.find(
//				"from Role r inner join fetch r.users u where u.uid=?", uid);
		for (Role role : allRoles) {// 遍历所有的role
			for (Role role2 : userRoles) {// 遍历用户能够访问到的role
				if (role.getRid().longValue() == role2.getRid().longValue()) {
					role.setChecked(true);
					break;
				}
			}
		}
		return allRoles;
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
