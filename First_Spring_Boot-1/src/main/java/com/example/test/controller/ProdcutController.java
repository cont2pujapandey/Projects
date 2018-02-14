package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;

@RestController
@RequestMapping(value = "/product")
public class ProdcutController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)

	public List<User> getList() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{id}")
	public User read(@PathVariable String id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}

}
