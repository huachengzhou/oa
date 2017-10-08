package cn.blake.shoa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.blake.shoa.dao.DepartmentDao;
import cn.blake.shoa.domain.Department;
import cn.blake.shoa.domain.User;
import cn.blake.shoa.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	public Collection<Department> getAllDepartment() {
		return departmentDao.getAllEntry(Department.class);
	}

	@Transactional(readOnly=false)
	public void DepartmentSave(Department department) {
		departmentDao.saveEntry(department);
	}
	@Transactional(readOnly=false)
	public void deleteDepartment(Integer id) {
		Department department = getDepartmentById(id);
		try {
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) department.getUsers();
			if (users != null) {
				for (User user : users) {/* 防止误删,增加安全性 */
					user.setDepartment(null);
				}
			}
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
		}
		departmentDao.deleteEntry(id,Department.class);
	}

	public Department getDepartmentById(Serializable id) {
		return departmentDao.getEntryById(id,Department.class);
	}
	@Transactional(readOnly=false)
	public void updateDepartment(Department department) {
		departmentDao.updateEntry(department);
	}
}
