package cn.blake.shoa.dao;

import java.util.Collection;

import cn.blake.shoa.dao.base.BaseDao;
import cn.blake.shoa.domain.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {
	public Collection<Privilege> getPrivilegesByRid(Integer rid);

	public Collection<Privilege> getMenuitemsByUid(Integer uid, String username);

	/**
	 * 根据用户ID得到该用户的功能权限
	 * 
	 * @param uid
	 * @return
	 */
	public Collection<Privilege> getFunctionsByUid(Integer uid);
}
