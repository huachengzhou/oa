package cn.blake.shoa.dao;

import java.util.Collection;

import cn.blake.shoa.dao.base.BaseDao;
import cn.blake.shoa.domain.Role;

public interface RoleDao extends BaseDao<Role> {
	public Collection<Role> getRoles(Integer uid);
}
