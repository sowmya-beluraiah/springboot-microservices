package com.sowmya.rest.webservices.restfulwebservices.modeldto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

//@JsonIgnoreProperties(value={"field2", "field3"})
@Getter
@Setter
public class StaticFilterBean {
	
	//Static Filtering is applied using @JsonIgnore OR @JsonIgnoreProperties
	@JsonIgnore
	private String field1;
	
	private String field2;
	
	private String field3;

	public StaticFilterBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	
}
