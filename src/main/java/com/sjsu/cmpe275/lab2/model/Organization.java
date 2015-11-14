package com.sjsu.cmpe275.lab2.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name="organization")
public class Organization {

	@Id
	@Column(name="idOrg")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	private String name;
    
	private String description;
    
	@Embedded
	private Address address;
	
	public Organization(long id, String name, String description,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
	}
	
	public Organization() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

    
}
