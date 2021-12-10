package com.sowmya.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowmya.rest.webservices.restfulwebservices.meta.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
