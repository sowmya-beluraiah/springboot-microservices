package com.sowmya.rest.webservices.restfulwebservices.modeldto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private Integer id;
	
	@Size(min=2, message="Name should be atleast 2 characters")
	private String name;
	
	@Past
	private Date dob;

}
