package test.service;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import cn.blake.shoa.domain.Department;
import cn.blake.shoa.domain.Role;
import cn.blake.shoa.domain.User;
import cn.blake.shoa.service.DepartmentService;
import cn.blake.shoa.service.RoleService;
import cn.blake.shoa.service.UserService;
import cn.blake.util.MyMD5Util;
import cn.blake.util.SessionFactoryUtil;
import edu.princeton.cs.algs4.StdRandom;

public class UserServiceTest {
	private ApplicationContext ctx = SessionFactoryUtil.getCtx();
	private UserService userService = ctx.getBean(UserService.class);
	private DepartmentService departmentService = ctx.getBean(DepartmentService.class);
	private RoleService roleService = ctx.getBean(RoleService.class);
	
	@Test
	public void loginUser(){
		User user = userService.loginUser("blake");
		System.out.println(user);
	}
	
	@Test
	public void addUser()throws Exception{
		User user = new User();
		user.setName("¿Ó");
		user.setUsername("lee");
		user.setPassword(MyMD5Util.getEncryptedPwd("123456"));
		user.setEmail("lee@163.com");
		user.setPhone(StdRandom.uniform(26767899,36767899)+"");
		user.setSex(User.SEX_MAN);
		Department department = departmentService.getDepartmentById(3);
		Collection<Role> roles = roleService.getAllRole();
		HashSet<Role> rSet = new HashSet<Role>(roles);
		user.setRoles(rSet);
		user.setDepartment(department);
		userService.saveUser(user);
	}
}
