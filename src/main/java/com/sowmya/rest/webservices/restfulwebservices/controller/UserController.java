package com.sowmya.rest.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sowmya.rest.webservices.restfulwebservices.meta.Post;
import com.sowmya.rest.webservices.restfulwebservices.meta.User;
import com.sowmya.rest.webservices.restfulwebservices.modeldto.UserDTO;
import com.sowmya.rest.webservices.restfulwebservices.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<UserDTO> getUser(@PathVariable Integer id) {
		UserDTO user = userService.getUser(id);
		
		// EntityModel supports returning resource with a link
		EntityModel<UserDTO> model = EntityModel.of(user);
		
		//WebMvcLinkBuilder is used to build links to be sent in response along with resource
		//"linkTo" and "methodOn" are static methods of WebMvcLinkBuilder used to construct links
		//linkTo says build a link to given paramenter
		//methodOn says build a link to the method in given class and method name
		WebMvcLinkBuilder linkToAllUsers = linkTo(methodOn(this.getClass()).getUsers());
		
		//Add that link to response under "all-users" token
		model.add(linkToAllUsers.withRel("all-users"));
		
		return model;
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody UserDTO user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id){
		return userService.getAllPosts(id);
	}
}
