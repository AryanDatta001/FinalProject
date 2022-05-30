package com.student.service;

import java.util.List;

import com.student.model.School;


public interface SchoolService {
	
	public School save(School school);

	public List<School> getSchoolById(String schoolId);
	
	public List<School> getSchoolByIdAndClassId(String schoolId, String classId);

}
