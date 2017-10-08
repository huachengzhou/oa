package cn.blake.shoa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import cn.blake.shoa.domain.Role;

/**
 * @see 岗位业务层
 * @author Blake.Zhou
 *
 */
public interface RoleService {
	/**
	 * @see 获取所有岗位
	 * @return
	 */
	public Collection<Role> getAllRole();

	/**
	 * @see 获取岗位
	 * @param id
	 * @return
	 */
	public Role getRoleById(Serializable id);

	/**
	 * @see 修改岗位
	 * @param role
	 */
	public void updateRole(Role role);

	/**
	 * @see 删除岗位
	 * @param id
	 */
	public void deleteRole(Serializable id);

	/**
	 * @see 添加岗位
	 * @param role
	 */
	public void saveRole(Role role);
	
	public Set<Role> getEntrysByIDS(Serializable[] ids);
	public Set<Role> getEntrysByIDS(String ids);
	public Collection<Role> getRolesByUid(Integer uid);
	public Collection<Role> getRoles(Integer uid);
	public void updateRole_(Role role);
}
