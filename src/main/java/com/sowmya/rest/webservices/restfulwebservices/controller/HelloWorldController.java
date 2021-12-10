package com.sowmya.rest.webservices.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//To support i18n using Message bundling via messages properties file for each locale
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/hello-world")
	public String HelloWorld() {
		return "Good Morning";
	}
	
	@GetMapping("/hello-world-internationalization")
	public String HelloWorldi18n() {
		
		/* If Locale (Accept-Language) specified then respective properties file is used
		 * otherwise, then messages.properties file is used as default
		 */
		return  messageSource.getMessage
				("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
