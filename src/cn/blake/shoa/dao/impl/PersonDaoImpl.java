package cn.blake.shoa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.PersonDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.Person;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

}
