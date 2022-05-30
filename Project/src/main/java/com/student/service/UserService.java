package com.student.service;

import java.util.List;

import com.student.model.Users;


public interface UserService {
	
	public Users saveUser(Users user);
    public List<Users> getUserById(String userId);
    public List<Users> findUserBySchoolIdRole(String schoolId, String role);

}