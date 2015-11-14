package com.sjsu.cmpe275.lab2.service;

import com.sjsu.cmpe275.lab2.model.Person;

public interface IPersonService {

	public void addPerson(Person p);
	public Person getPersonById(Long id);
	public void updatePerson(Person p);
	public void deletePersonById(Long id);
}
