package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.UserReqDto;
import com.demo.entities.User;
import com.demo.entities.UserPersonalInfo;
import com.demo.repositories.UserPersonalInfoRepo;
import com.demo.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepo;
	private final UserPersonalInfoRepo personalInfoRepo;
	
	public UserService(UserRepo userRepo, UserPersonalInfoRepo personalInfoRepo) {
		this.userRepo = userRepo;
		this.personalInfoRepo = personalInfoRepo;
	}
	
	public ResponseEntity<?> getAllUsers() {
		List<User> users = new ArrayList<User>();
		
		userRepo.findAll().forEach(users::add);
		
		return ResponseEntity.ok(users);
	}
	
	public ResponseEntity<?> addUser(UserReqDto reqDto) {
		User user = new User();
		UserPersonalInfo personal = new UserPersonalInfo();
		
		personal.setAddress(reqDto.getAddress());
		personal.setFullName(reqDto.getFullName());
		personal.setMobile(reqDto.getMobile());
		
		user.setUsername(reqDto.getUsername());
		user.setPersonalInfo(personal);
		
		User saved = userRepo.save(user);
		
		return ResponseEntity.ok(saved);
	}

	public ResponseEntity<?> deleteUser(long userId) {
		userRepo.deleteById(userId);
		return ResponseEntity.ok("User deleted");
	}
}
