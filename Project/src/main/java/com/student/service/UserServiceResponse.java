package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Users;
import com.student.repository.UserRepository;

@Service
public class UserServiceResponse implements UserService{

	@Autowired
	UserRepository userRepository;
    //function to save the new users
	@Override
	public Users saveUser(Users user) {
		return userRepository.save(user);
		
	}
    //function to get user by its id
	@Override
	public List<Users> getUserById(String userId) {
		return userRepository.findUserById(userId);
	}

	@Override
	public List<Users> findUserBySchoolIdRole(String schoolId, String role) {
		return userRepository.findUserBySchoolIdRole(schoolId, role);
	}

}
