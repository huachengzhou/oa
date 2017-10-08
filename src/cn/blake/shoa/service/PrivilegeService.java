package cn.blake.shoa.service;

import java.util.Collection;
import java.util.Set;

import cn.blake.shoa.domain.Privilege;

public interface PrivilegeService {
	public Collection<Privilege> getPrivilegesByRid(Integer rid);

	public void savePrivilege(Integer rid, String checkedStr);

	public Set<Privilege> getPrivileges(String checkedStr);

	/**
	 * @see Blake
	 * @param uid
	 * @param username
	 * @return
	 */
	public Collection<Privilege> getPrivilegesByUid(Integer uid, String username);

	/**
	 * @see ∆’Õ®‘±π§
	 * @param uid
	 * @return
	 */
	public Collection<Privilege> getPrivilegesByUid(Integer uid);
}
