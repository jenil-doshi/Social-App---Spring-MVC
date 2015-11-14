package com.sjsu.cmpe275.lab2.controller;

import java.util.List;

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
import com.sjsu.cmpe275.lab2.service.IPersonService;

@Controller
@RequestMapping("/")
public class PersonController {

	@Autowired
	IPersonService personService;
	
	@Autowired
	IOrganizationService organizationService;

	@RequestMapping(value = { "/person/{id}" }, method = RequestMethod.GET)
	public String addPersonHtml(ModelMap model, @PathVariable Long id) {
		
		Person p = personService.getPersonById(id);
		model.addAttribute("person", p);
		model.addAttribute("friends", p.getFriends());
		return "personDetails";
	}
	
	@RequestMapping(value = { "/person" }, method = RequestMethod.POST, 
			produces = {"application/json", "application/xml" })
	public @ResponseBody ResponseEntity<Person> addPerson(
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip,
			@RequestParam(value = "idOrg", required = false) Long idOrganization) {

		if(firstname == null || lastname == null || email == null){
			return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
		}
			
		
		Person p = new Person();
		Address a = new Address();
		Organization o = new Organization();

		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setEmail(email);

		if (description == null)
			p.setDescription(null);
		else
			p.setDescription(description);

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

		p.setAddress(a);

		if (idOrganization == null)
			o = null;
		else
			o.setId(idOrganization);

		p.setOrg(o);

		personService.addPerson(p);

		return new ResponseEntity<Person>(p, HttpStatus.OK);

	}

	@RequestMapping(value = { "/person/{id}" }, method = RequestMethod.GET, 
			produces = {"application/json", "application/xml"})
	public @ResponseBody ResponseEntity<Person> getPerson(@PathVariable Long id) {
		Person p = personService.getPersonById(id);

		if (p == null){
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		else
			return new ResponseEntity<Person>(p, HttpStatus.OK);
	}

	@RequestMapping(value = { "/person/{id}" }, method = RequestMethod.POST, produces = {
			"application/json", "application/xml" })
	public @ResponseBody
	ResponseEntity<Person> updatePerson(
			@PathVariable Long id,
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip,
			@RequestParam(value = "idOrg", required = false) Long idOrganization) {

		Person p = personService.getPersonById(id);
		if (p == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		
		Address a = new Address();
		Organization o = new Organization();

		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setEmail(email);

		if (description == null)
			p.setDescription(null);
		else
			p.setDescription(description);

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

		p.setAddress(a);

		if (idOrganization == null)
			o = null;
		else{
			Organization org = organizationService.getOrganizationById(idOrganization);
			Address adrr = org.getAddress();
			o.setId(org.getId());
			o.setDescription(org.getDescription());
			o.setName(org.getName());
			o.setAddress(adrr);
		}

		p.setOrg(o);

		personService.updatePerson(p);

		return new ResponseEntity<Person>(p, HttpStatus.OK);

	}
	
	@RequestMapping(value = { "/person/{id}" }, method = RequestMethod.DELETE, produces = {
			"application/json", "application/xml" })
	public @ResponseBody
	ResponseEntity<Person> deletePerson(@PathVariable Long id) {
		Person p = personService.getPersonById(id);
		if(p == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		
		List<Person> frnds = p.getFriends();
		frnds.clear();
		p.setFriends(frnds);

		personService.updatePerson(p);
		System.out.println("Friendship Deleted");
		personService.deletePersonById(id);
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}
}
