package cn.blake.shoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.blake.shoa.dao.PersonDao;
import cn.blake.shoa.domain.Person;
import cn.blake.shoa.service.PersonService;
@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	
	@Transactional(readOnly=false)
	public void savePerson(Person person) {
		personDao.saveEntry(person);
	}

}
