package test.n1;

import java.util.Collection;

import org.hibernate.Session;

import words.Words;
import cn.blake.shoa.domain.Department;
import cn.blake.shoa.service.DepartmentService;
import cn.blake.util.SessionFactoryUtil;

public class DepartmentServiceTest {
	Session session = SessionFactoryUtil.getSessionFactory().openSession();
	DepartmentService departmentService = SessionFactoryUtil.getCtx().getBean(DepartmentService.class);

	public static void main(String[] args) {
		DepartmentServiceTest hibernateTest = new DepartmentServiceTest();
		hibernateTest.deleteDepartment();
	}
	public void departmentSaveTest(){
		Department department = new Department("市场部门","市场业务相关事务");
		departmentService.DepartmentSave(department);
	}
	public void getAllDepartmentTest(){
		Collection<Department> departments = departmentService.getAllDepartment();
		for (Department department : departments) {
			System.out.println(department);
		}
	}
	public void getDepartmentByIdTest(){
		Department department = departmentService.getDepartmentById(2);
		System.out.println(department);
	}
	public void updateDepartmentTest(){
		Department department = departmentService.getDepartmentById(2);
		department.setDescription("财务业务相关事务 "+Words.getWords(3));
		departmentService.updateDepartment(department);
	}
	public void deleteDepartment(){
		departmentService.deleteDepartment(6);
		System.out.println("deleteDepartment()");
	}

}
