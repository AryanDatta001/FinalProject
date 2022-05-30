package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.School;
import com.student.repository.SchoolRepository;

@Service
public class SchoolServiceResponse implements SchoolService {

	@Autowired
	SchoolRepository schoolRepository;

	//function to save the school information
	@Override
	public School save(School school) {
		return schoolRepository.save(school);
	}

	//function to find the school by its id
	@Override
	public List<School> getSchoolById(String schoolId) {
		return schoolRepository.findSchoolById(schoolId);
	}
	//function to find the schoolId and classId
	@Override
	public List<School> getSchoolByIdAndClassId(String schoolId, String classId) {
		return schoolRepository.getSchoolByIdAndClassId(schoolId, classId );
	}
	
}
