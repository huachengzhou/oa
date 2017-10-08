package cn.blake.shoa.dao;

import cn.blake.shoa.dao.base.BaseDao;
import cn.blake.shoa.domain.User;

public interface UserDao extends BaseDao<User>{
	public User loginUser(String username);
}
