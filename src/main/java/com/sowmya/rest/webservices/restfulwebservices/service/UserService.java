package com.sowmya.rest.webservices.restfulwebservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowmya.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.sowmya.rest.webservices.restfulwebservices.meta.Post;
import com.sowmya.rest.webservices.restfulwebservices.meta.User;
import com.sowmya.rest.webservices.restfulwebservices.modeldto.UserDTO;
import com.sowmya.rest.webservices.restfulwebservices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}

	public UserDTO getUser(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with id:"+id);
		}
		
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user.get(), dto);
		return dto;
	}

	public User createUser(UserDTO dto) {
		User meta = new User();
		BeanUtils.copyProperties(dto, meta);
		meta = userRepo.save(meta);
		return meta;
	}

	public List<Post> getAllPosts(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not found with id:"+id);
		}

		return user.get().getPosts();
	}
}
