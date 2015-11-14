package com.sjsu.cmpe275.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjsu.cmpe275.lab2.dao.IPersonDao;
import com.sjsu.cmpe275.lab2.dao.PersonDaoImpl;
import com.sjsu.cmpe275.lab2.model.Person;
import com.sjsu.cmpe275.lab2.service.IPersonService;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService{

	@Autowired
	public IPersonDao personDao;
	
	public void addPerson(Person p) {
		personDao.addPerson(p);
	}

	public Person getPersonById(Long id) {
		return personDao.getPersonById(id);
	}

	public void updatePerson(Person p) {
		personDao.updatePerson(p);
	}

	public void deletePersonById(Long id) {
		personDao.deletePersonById(id);
	}

}
