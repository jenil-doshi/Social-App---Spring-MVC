package com.sjsu.cmpe275.lab2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class FriendController {
/*
	@Autowired
	IFriendService friendService;
	*/
	@Autowired
	IPersonService personService;

	@RequestMapping(value = { "/friends/{id1}/{id2}" }, method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Person> addFriends(@PathVariable Long id1, @PathVariable Long id2) {
		Person p1 = personService.getPersonById(id1);
		Person p2 = personService.getPersonById(id2);
		p1.getFriends().add(p2);
		//p2.getFriends().add(p1);
		
		if(p1 == null || p2 == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		else
		{
			personService.updatePerson(p1);
			return new ResponseEntity<Person>(p1, HttpStatus.OK);
		}	
	}
	
	@RequestMapping(value = { "/friends/{id1}/{id2}" }, method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Person> deleteFriends(@PathVariable Long id1, @PathVariable Long id2) {
		Person p1 = personService.getPersonById(id1);
		Person p2 = personService.getPersonById(id2);
		List<Person> frnds = p1.getFriends();
		
		for(int i=0; i<frnds.size(); i++){
			if(frnds.get(i).getId() == p2.getId()){
				frnds.remove(i);
			}
		}
		
		for(Person person : frnds){
			System.out.println("After: " + person.getId());
		}
		
		p1.setFriends(frnds);
		if(p1 == null || p2 == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		else
		{
			personService.updatePerson(p1);
			return new ResponseEntity<Person>(p1, HttpStatus.OK);
		}	
	}
	
}
