package com.sjsu.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe275.lab2.model.Address;
import com.sjsu.cmpe275.lab2.model.Organization;
import com.sjsu.cmpe275.lab2.model.Person;
import com.sjsu.cmpe275.lab2.service.IOrganizationService;

@Controller
@RequestMapping("/")
public class OrganizationController {

	@Autowired
	IOrganizationService organizationService;
	
	@RequestMapping(value = { "/org/{id}" }, method = RequestMethod.GET)
	public String getOrgHtml(ModelMap model, @PathVariable Long id) {
		Organization o = organizationService.getOrganizationById(id);
		model.addAttribute("org", o);
		return "orgDetails";

	}
	
	@RequestMapping(value = { "/org" }, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Organization> addOrg(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		System.out.println("Inside Add Org Controller");
		
		Organization o = new Organization();

		o.setName(name);
		o.setDescription(description);
		
		Address a = new Address();
		a.setCity(city);
		a.setState(state);
		a.setStreet(street);
		a.setZip(zip);
		
		o.setAddress(a);

		organizationService.addOrganization(o);
		
		return new ResponseEntity<Organization>(o, HttpStatus.OK);

	}
	
	@RequestMapping(value = { "/org/{id}" }, method = RequestMethod.GET,
			produces = {"application/json", "application/xml" })
	public @ResponseBody ResponseEntity<Organization> getOrg(@PathVariable Long id) {
		Organization o = organizationService.getOrganizationById(id);

		if (o == null)
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Organization>(o, HttpStatus.OK);

	}
	
	@RequestMapping(value = { "/org/{id}" }, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Organization> updatePerson(
			@PathVariable Long id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		
		Organization o = organizationService.getOrganizationById(id);
		
		if(o == null)
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
		
		Address a = new Address();

		o.setName(name);

		if (description == null)
			o.setDescription(null);
		else
			o.setDescription(description);

		if (city == null)
			a.setCity(null);
		else
			a.setCity(city);

		if (state == null)
			a.setState(null);
		else
			a.setState(state);

		if (street == null)
			a.setStreet(null);
		else
			a.setStreet(street);

		if (zip == null)
			a.setZip(null);
		else
			a.setZip(zip);

		o.setAddress(a);

		organizationService.updateOrganization(o);

		return new ResponseEntity<Organization>(o, HttpStatus.OK);

	}
	
	@RequestMapping(value = { "/org/{id}" }, method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Organization> deleteOrg(@PathVariable Long id) {
		Organization o = organizationService.getOrganizationById(id);
		if(o == null)
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);
		else
		{
			organizationService.deleteOrganizationById(id);
			return new ResponseEntity<Organization>(o, HttpStatus.OK);
		}	
	}
}
