package com.sjsu.cmpe275.lab2.service;

import com.sjsu.cmpe275.lab2.model.Organization;
import com.sjsu.cmpe275.lab2.model.Person;

public interface IOrganizationService {

	public void addOrganization(Organization o);
	public Organization getOrganizationById(Long id);
	public void updateOrganization(Organization o);
	public void deleteOrganizationById(Long id);
}
