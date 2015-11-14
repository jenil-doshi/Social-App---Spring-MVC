package com.sjsu.cmpe275.lab2.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe275.lab2.dao.IPersonDao;
import com.sjsu.cmpe275.lab2.model.Organization;
import com.sjsu.cmpe275.lab2.model.Person;

@Repository
public class OrganizationDaoImpl implements IOrganizationDao{

	@Autowired
	private SessionFactory session;

	public void addOrganization(Organization o) {
		session.getCurrentSession().save(o);
	}

	public Organization getOrganizationById(Long id) {
		return (Organization) session.getCurrentSession().get(Organization.class, id);
	}

	public void updateOrganization(Organization o) {
		session.getCurrentSession().update(o);
	}

	public void deleteOrganizationById(Long id) {
		session.getCurrentSession().delete(getOrganizationById(id));
	}

}
