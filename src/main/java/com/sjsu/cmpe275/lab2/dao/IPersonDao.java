package com.sjsu.cmpe275.lab2.dao;

import com.sjsu.cmpe275.lab2.model.*;

public interface IPersonDao {

	public void addPerson(Person p);
	public Person getPersonById(Long id);
	public void updatePerson(Person p);
	public void deletePersonById(Long id);
}
