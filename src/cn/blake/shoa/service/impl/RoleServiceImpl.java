package cn.blake.shoa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.blake.shoa.dao.RoleDao;
import cn.blake.shoa.domain.Role;
import cn.blake.shoa.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	public Collection<Role> getAllRole() {
		return roleDao.getAllEntry(Role.class);
	}

	public Role getRoleById(Serializable id) {
		return roleDao.getEntryById(id,Role.class);
	}

	@Transactional(readOnly = false)
	public void updateRole(Role role) {
		 roleDao.updateEntry(role);
	}

	@Transactional(readOnly = false)
	public void deleteRole(Serializable id) {
		roleDao.deleteEntry(id,Role.class);
	}

	@Transactional(readOnly = false)
	public void saveRole(Role role) {
		roleDao.saveEntry(role);
	}


	public Set<Role> getEntrysByIDS(Serializable[] ids) {
		Set<Role> roles = roleDao.getEntrysByIDS(Role.ROLE_RID_NAME,ids,Role.class);
		return roles;
	}

	public Collection<Role> getRolesByUid(Integer uid) {
		return roleDao.getRoles(uid);
	}

	public Set<Role> getEntrysByIDS(String ids) {
		Set<Role> roles = roleDao.getEntrysByIDS(Role.ROLE_RID_NAME, ids,Role.class);
		return roles;
	}

	public Collection<Role> getRoles(Integer uid) {
		return roleDao.getRoles(uid);
	}
	@Transactional(readOnly = false)
	public void updateRole_(Role role) {
		roleDao.updateEntry(role);
	}
}
