package cn.blake.shoa.service.impl;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.blake.shoa.dao.PrivilegeDao;
import cn.blake.shoa.dao.RoleDao;
import cn.blake.shoa.domain.Privilege;
import cn.blake.shoa.domain.Role;
import cn.blake.shoa.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	private PrivilegeDao privilegeDao;
	@Autowired
	private RoleDao roleDao;

	public Collection<Privilege> getPrivilegesByRid(Integer rid) {
		return privilegeDao.getPrivilegesByRid(rid);
	}
	@Transactional(readOnly=false)
	public void savePrivilege(Integer rid, String checkedStr) {
		Role role = roleDao.getEntryById(rid,Role.class);
		Set<Privilege> privileges = privilegeDao.getEntrysByIDS(Privilege.PRIVILEGE_ID_NAME,checkedStr,Privilege.class);
		/* 建立角色和权限之间的关系 */
		role.setPrivileges(privileges);
		roleDao.updateEntry(role);
	}

	public Collection<Privilege> getPrivilegesByUid(Integer uid, String username) {
		return privilegeDao.getMenuitemsByUid(uid, username);
	}
	public Set<Privilege> getPrivileges(String checkedStr) {
		Set<Privilege> privileges = privilegeDao.getEntrysByIDS(Privilege.PRIVILEGE_ID_NAME,checkedStr,Privilege.class);
		return privileges;
	}
	public Collection<Privilege> getPrivilegesByUid(Integer uid) {
		return privilegeDao.getFunctionsByUid(uid);
	}

}
