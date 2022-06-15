package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User insertUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return savedUser;
	}

	@GetMapping("/getuser")
	public List<User> fetchUserList() {
		return userService.fetchUserList();
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserId(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@GetMapping("/department/{id}")
	public List<User> getAllUsersBydepartId(@PathVariable("id") int id) {
		return userService.findAllBydepartId(id);
	}

	@GetMapping("/category/{categoryId}")
	public List<User> getAllUsersByQualificationCategoryId(@PathVariable ("categoryId") int categoryId) {
		return userService.findAllByQualificationCategoryId(categoryId);
	}
	

	@GetMapping("/qualification/{qualiName}")
	public List<User> getAllUsersByQualificationQualiName(@PathVariable ("qualiName") String qualiName) {
		return userService.findAllByQualificationQualiName(qualiName);
	}

	@GetMapping("/category")
	public List<User> fetchCategoryList() {
		return userService.fetchCategoryList();
	}

	@GetMapping("/department")
	public List<User> fetchDepartmentList() {
		return userService.fetchDepartmentList();
	}

	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
		return userService.updateUser(user, id);
	}

}
