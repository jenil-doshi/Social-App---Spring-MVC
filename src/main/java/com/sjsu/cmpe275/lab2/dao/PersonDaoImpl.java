package com.sjsu.cmpe275.lab2.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe275.lab2.dao.IPersonDao;
import com.sjsu.cmpe275.lab2.model.Person;

@Repository
public class PersonDaoImpl implements IPersonDao{

	@Autowired
	private SessionFactory session;
	
	public void addPerson(Person p) {
		session.getCurrentSession().save(p);
	}

	public Person getPersonById(Long id) {
		return (Person) session.getCurrentSession().get(Person.class, id);
	}

	public void updatePerson(Person p) {
		session.getCurrentSession().update(p);
	}

	public void deletePersonById(Long id) {
		session.getCurrentSession().delete(getPersonById(id));;
	}
}
