package com.student.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{

	@Query("{ 'userId' : ?0 }")
	List<Users> findUserById(String userId);
	
	@Query("{ 'schoolId' : ?0, 'role' : ?1 }")
	List<Users> findUserBySchoolIdRole(String schoolId, String role);
}
