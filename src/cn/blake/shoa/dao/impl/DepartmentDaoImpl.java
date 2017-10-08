package cn.blake.shoa.dao.impl;


import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.DepartmentDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

}
