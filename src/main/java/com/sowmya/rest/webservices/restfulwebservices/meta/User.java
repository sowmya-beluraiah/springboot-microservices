package com.sowmya.rest.webservices.restfulwebservices.meta;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min=2, message="Name should be atleast 2 characters")
	private String name;
	
	@Past
	private Date dob;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

}
