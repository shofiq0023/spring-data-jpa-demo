package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.UserReqDto;
import com.demo.services.UserService;

@RestController
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody UserReqDto reqDto) {
		return userService.addUser(reqDto);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long userId) {
		return userService.deleteUser(userId);
	}
}
