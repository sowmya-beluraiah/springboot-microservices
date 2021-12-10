package com.sowmya.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sowmya.rest.webservices.restfulwebservices.modeldto.DynamicFilterBean;
import com.sowmya.rest.webservices.restfulwebservices.modeldto.StaticFilterBean;

@RestController
public class FilteringController {

	@GetMapping("/static-filtering")
	public List<StaticFilterBean> retrieveStaticFilteringBean() {
		return Arrays.asList(new StaticFilterBean("value11", "value12", "value13"),
				new StaticFilterBean("value21", "value22", "value23"));
	}
	
	@GetMapping("/dynamic-filtering-1")
	public MappingJacksonValue retrieveDynamicFilteringBean1() {
		//Create POJO DTO
		DynamicFilterBean filterBean = new DynamicFilterBean("value1", "value2", "value3");
		
		//Create a filter to filter out fields from POJO DTO
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1","field2");
		
		//Create filter provider and add above filter and give name to it
		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("DynamicFilter", filter);
		
		//Create mapping object and set filter provider to the return type bean	
		MappingJacksonValue mappingValue = new MappingJacksonValue(filterBean);
		mappingValue.setFilters(filterProvider);
		
		return mappingValue;
	}

	@GetMapping("/dynamic-filtering-2")
	public MappingJacksonValue retrieveDynamicFilteringBean2() {
		List<DynamicFilterBean> filterBeanList = Arrays.asList(
				new DynamicFilterBean("value11", "value12", "value13"),
				new DynamicFilterBean("value21", "value22", "value23"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field3");
		
		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("DynamicFilter", filter);
		
		MappingJacksonValue mappingValue = new MappingJacksonValue(filterBeanList);
		mappingValue.setFilters(filterProvider);
		
		return mappingValue;
	}
}
