package com.sjsu.cmpe275.lab2.dao;

import com.sjsu.cmpe275.lab2.model.*;

public interface IOrganizationDao {

	public void addOrganization(Organization o);
	public Organization getOrganizationById(Long id);
	public void updateOrganization(Organization o);
	public void deleteOrganizationById(Long id);
}
