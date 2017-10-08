package test.n1;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import cn.blake.shoa.domain.Privilege;
import cn.blake.shoa.domain.Role;
import cn.blake.shoa.service.RoleService;
import cn.blake.util.SessionFactoryUtil;


public class RoleTest{
	RoleService roleService = SessionFactoryUtil.getCtx().getBean(RoleService.class);
	Session session = SessionFactoryUtil.getSessionFactory().openSession();
	public static void main(String[] args) {
		RoleTest roleTest = new RoleTest();
		roleTest.getRolesByUid();
		
		roleTest.session.close();
	}
	public void getRolesByUid(){
		Collection<Role> collection = roleService.getRolesByUid(61);
		for (Role role : collection) {
			System.out.println(role);
		}
	}
	public void testSaveRole(){
		/**
		 * 用户角色、岗位角色、部门角色
		 */
		Role role1 = new Role();
		role1.setName("用户角色");
		role1.setDescription("拥有用户模块的crud的操作");
		//建立角色和权限之间的关联
		@SuppressWarnings("unchecked")
		List<Privilege> privileges1 = session.createQuery("from Privilege where id in(38,39,40,41)").list();
		//role1.setPrivileges(new HashSet<Privilege>(privileges1));
		roleService.saveRole(role1);
		
		Role role2 = new Role();
		role2.setName("部门角色");
		role2.setDescription("拥有部门模块的crud的操作");
		//建立角色和权限之间的关联
		List<Privilege> privileges2 = session.createQuery("from Privilege where id in(42,44,45,46)").list();
		//role2.setPrivileges(new HashSet<Privilege>(privileges2));
		roleService.saveRole(role2);
		
		Role role3 = new Role();
		role3.setName("岗位角色");
		role3.setDescription("拥有岗位模块的crud的操作");
		//建立角色和权限之间的关联
		List<Privilege> privileges3 = session.createQuery("from Privilege where id in(43,47,48,49)").list();
		//role3.setPrivileges(new HashSet<Privilege>(privileges3));
		roleService.saveRole(role3);
		
	}
}
