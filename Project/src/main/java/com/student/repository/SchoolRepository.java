package com.student.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.student.model.School;

@Repository
public interface SchoolRepository  extends MongoRepository<School, String>{
	@Query("{ 'schoolId' : ?0 }")
	List<School> findSchoolById(String schoolId);
	
	@Query("{ 'schoolId' : ?0, 'classDetails.classCode' : ?1 }")
	List<School> getSchoolByIdAndClassId(String schoolId, String classCode);

}
