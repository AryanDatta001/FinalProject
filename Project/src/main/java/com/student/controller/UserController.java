package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.model.School;
import com.student.model.Users;
import com.student.repository.SchoolRepository;
import com.student.repository.UserRepository;
import com.student.service.UserService;

@RestController

public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	//to generate a new user in data
	@PostMapping( "/user/generate")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
		
		if (user==null || user.getUserId().isEmpty()) {
		    return new ResponseEntity<>("Invalid Input",HttpStatus.BAD_REQUEST);
		  }
		Users resSchool  =userService.saveUser(user);
		return  new ResponseEntity<>(resSchool, HttpStatus.OK);
    }
    //to get all the users in data
	@GetMapping("/users")
    public ResponseEntity<?> getUser() {
		
		List<Users> result  =userRepository.findAll();
		if(result.isEmpty()) {
			 return new ResponseEntity<>("No data found", HttpStatus.OK);
		}
		return  new ResponseEntity<>(result, HttpStatus.OK);
    }
	//to get user by their ID
	@GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String userId) {
		
		if (userId.isEmpty()) {
		    return new ResponseEntity<>("userId Can not be null", HttpStatus.BAD_REQUEST);
		  }
		
		List<Users> result= userService.getUserById(userId);
		if(result==null || result.isEmpty()) {
			 return new ResponseEntity<>("No data found", HttpStatus.OK);
		}
		return  new ResponseEntity<>(result, HttpStatus.OK);
    }
	

	//to get users by their schoolId and role
	@GetMapping("/user/{schoolId}/role/{role}")
    public ResponseEntity<?> getUserByRole(@PathVariable("schoolId") String schoolId, @PathVariable("role") String role) {
		
		if (schoolId.isEmpty()) {
		    return new ResponseEntity<>("School Id Can not be null", HttpStatus.BAD_REQUEST);
		  }
		
		List<Users> result= userService.findUserBySchoolIdRole(schoolId, role);
		if(result==null || result.isEmpty()) {
			 return new ResponseEntity<>("No record found", HttpStatus.OK);
		}
		return  new ResponseEntity<>(result, HttpStatus.OK);
    }
}
