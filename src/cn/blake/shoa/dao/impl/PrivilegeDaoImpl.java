package cn.blake.shoa.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.blake.shoa.common.Root_Final;
import cn.blake.shoa.dao.PrivilegeDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.Privilege;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Collection<Privilege> getPrivilegesByRid(Integer rid) {
		Collection<Privilege> allPrivilege = getAllEntry(Privilege.class);
		String hql = "from Privilege p inner join fetch p.roles r where r.rid=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0,rid);
		List<Privilege> rolePrivilege = query.list();
//		Collection<Privilege> rolePrivilege = (Collection<Privilege>) this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r where r.rid=?",rid);
		for (Privilege privilege : allPrivilege) {
			for (Privilege privilege2 : rolePrivilege) {
				if (privilege.getId().intValue()==privilege2.getId().intValue()) {
					privilege.setChecked(true);
					break;
				}
			}
		}
		return allPrivilege;
	}

	@SuppressWarnings("unchecked")
	public Collection<Privilege> getMenuitemsByUid(Integer uid, String username) {
		List<Privilege> privileges = null;
		if(Root_Final.N1.equals(username)){
			privileges = getSession().createQuery("from Privilege where flag='1'").list();
//			privileges = (List<Privilege>) hibernateTemplate.find("from Privilege where flag='1'");
		}else{
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("from Privilege p inner join fetch p.roles r inner join fetch r.users u");
			stringBuffer.append(" where u.uid=?");
			stringBuffer.append(" and flag='1'");
//			privileges = (List<Privilege>) hibernateTemplate.find(stringBuffer.toString(),uid);
			Query query = getSession().createQuery(stringBuffer.toString());
			query.setInteger(0,uid);
			privileges = query.list();
		}
		return new HashSet<Privilege>(privileges);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Privilege> getFunctionsByUid(Integer uid) {
		List<Privilege> privileges = null;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from Privilege p inner join fetch p.roles r inner join fetch r.users u");
		stringBuffer.append(" where u.uid=?");
		stringBuffer.append(" and flag='1'");
		Query query = getSession().createQuery(stringBuffer.toString());
		query.setInteger(0,uid);
		privileges = query.list();
//		privileges = (List<Privilege>) hibernateTemplate.find(stringBuffer.toString(),uid);
		return new HashSet<Privilege>(privileges);
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
