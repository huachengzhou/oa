package test.n1;

import java.util.Set;

import cn.blake.shoa.domain.Role;
import cn.blake.shoa.service.RoleService;
import cn.blake.util.SessionFactoryUtil;

public class RoleServiceTest {
	RoleService roleService = SessionFactoryUtil.getCtx().getBean(RoleService.class);
	public void getEntrysByIDS(){
		Integer[] ids = new Integer[]{2,3,6,7};
		Set<Role> roles = roleService.getEntrysByIDS(ids);
		for (Role role : roles) {
			System.out.println(role);
		}
	}
    public static void main(String[] args) {
    	RoleServiceTest serviceTest = new RoleServiceTest();
    	serviceTest.getEntrysByIDS();
	}
}
