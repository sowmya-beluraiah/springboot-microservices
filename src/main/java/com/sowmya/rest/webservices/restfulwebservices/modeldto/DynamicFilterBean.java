package com.sowmya.rest.webservices.restfulwebservices.modeldto;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Getter;
import lombok.Setter;

@JsonFilter("DynamicFilter")
@Getter
@Setter
public class DynamicFilterBean {
	private String field1;
	
	private String field2;
	
	private String field3;

	public DynamicFilterBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
}
