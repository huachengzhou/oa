package cn.blake.shoa.service;

import java.io.Serializable;
import java.util.Collection;

import cn.blake.shoa.domain.Department;

/**
 * 
 * @author Blake.Zhou
 * @see 部门 业务层
 */
public interface DepartmentService {
	/**
	 * @see 显示部门列表
	 * @return
	 */
	public Collection<Department> getAllDepartment();

	/**
	 * @see 添加相关部门
	 * @param department
	 */
	public void DepartmentSave(Department department);

	/**
	 * @see 删除部门
	 * @param id
	 */
	public void deleteDepartment(Integer id);

	/**
	 * @see 根据id 获取相关部门
	 * @param id
	 * @return
	 */
	public Department getDepartmentById(Serializable id);

	/**
	 * @see 修改相关部门
	 * @param department
	 */
	public void updateDepartment(Department department);
}
