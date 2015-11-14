package com.sjsu.cmpe275.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjsu.cmpe275.lab2.dao.IOrganizationDao;
import com.sjsu.cmpe275.lab2.dao.IPersonDao;
import com.sjsu.cmpe275.lab2.model.Organization;
import com.sjsu.cmpe275.lab2.model.Person;

@Service
@Transactional
public class OrganizationServiceImpl implements IOrganizationService {

	@Autowired
	public IOrganizationDao orgDao;
	
	public void addOrganization(Organization o) {
		orgDao.addOrganization(o);
	}

	public Organization getOrganizationById(Long id) {
		return orgDao.getOrganizationById(id);
	}

	public void updateOrganization(Organization o) {
		orgDao.updateOrganization(o);
	}

	public void deleteOrganizationById(Long id) {
		orgDao.deleteOrganizationById(id);
	}

}
