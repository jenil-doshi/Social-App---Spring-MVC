package com.sjsu.cmpe275.lab2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name="person")
public class Person{

	@Id
    @Column(name="idPerson")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	private String firstname;
    
	private String lastname;
    
	private String email;
    
	private String description;
    
	@Embedded
	private Address address;
    
	@OneToOne
	private Organization org;
    
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "Friendship", joinColumns = {@JoinColumn(name = "p1_id")}, inverseJoinColumns = {@JoinColumn(name = "p2_id")})
	private List<Person> friends = new ArrayList<Person>();

	public Person(long id, String firstname, String lastname, String email,
			String description, Address address, Organization org,
			List<Person> friends) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.description = description;
		this.address = address;
		this.org = org;
		this.friends = friends;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
}
