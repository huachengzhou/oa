package cn.blake.shoa.service;

import java.io.Serializable;
import java.util.Collection;

import cn.blake.shoa.domain.User;

/**
 * @see User 业务层
 * @author Blake.Zhou
 * 
 */
public interface UserService {
	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	public Collection<User> getAllUser();

	/**
	 * 保存用户
	 */
	public void saveUser(User user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * @see 处理异常
	 * @param user
	 * @param id
	 */

	/**
	 * 删除用户
	 */
	public void deleteUser(Serializable id);

	/**
	 * 根据id查询user
	 */
	public User getUserById(Serializable id);
	public User loginUser(String username);

}
