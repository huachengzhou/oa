package cn.blake.shoa.service.impl;

import cn.blake.shoa.dao.UserDao;
import cn.blake.shoa.domain.User;
import cn.blake.shoa.service.UserService;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	public Collection<User> getAllUser() {
		return userDao.getAllEntry(User.class);
	}

	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.saveEntry(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(User user) {
		userDao.updateEntry(user);
	}


	@Transactional(readOnly = false)
	public void deleteUser(Serializable id) {
		userDao.deleteEntry(id,User.class);
	}

	public User getUserById(Serializable id) {
		return userDao.getEntryById(id,User.class);
	}

	public User loginUser(String username) {
		return userDao.loginUser(username);
	}

}
