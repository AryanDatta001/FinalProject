package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.model.School;
import com.student.repository.SchoolRepository;
import com.student.service.SchoolService;

@RestController

public class SchoolController {

	@Autowired
	SchoolService studentService;

	@Autowired
	SchoolRepository schoolRepository;
    //to put the value of new school
	@PostMapping("/school/generate")
	public ResponseEntity<?> addSchools(@RequestBody School school) {

		if (school == null || school.getSchoolId().isEmpty()) {
			return new ResponseEntity<>("Invalid", HttpStatus.BAD_REQUEST);
		}
		School resSchool = studentService.save(school);
		return new ResponseEntity<>(resSchool, HttpStatus.OK);
	}
	
    //to get the info of all schools
	@GetMapping("/schools")
	public ResponseEntity<?> getSchools() {

		List<School> result = schoolRepository.findAll();
		if (result.isEmpty()) {
			return new ResponseEntity<>("No Data Found", HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
    //to get the info of school with id
	@GetMapping("/school/{schoolId}")
	public ResponseEntity<?> getSchoolById(@PathVariable("schoolId") String schoolId) {

		if (schoolId.isEmpty()) {
			return new ResponseEntity<>("School Id Can not be empty", HttpStatus.BAD_REQUEST);
		}

		List<School> result = studentService.getSchoolById(schoolId);
		if (result == null || result.isEmpty()) {
			return new ResponseEntity<>("No data found", HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
    //to get the info of a particular class using its id and school id
	@GetMapping( "/school/{schoolId}/class/{classId}")
	public ResponseEntity<?> getClassByClassIdAndSchoolId(@PathVariable("schoolId") String schoolId, @PathVariable("classId") String classId)
	{

		if (schoolId.isEmpty()) {
			return new ResponseEntity<>("School Id Can not be empty", HttpStatus.BAD_REQUEST);
		}

		if (classId.isEmpty()) {
			return new ResponseEntity<>("Class  Id can not be empty", HttpStatus.BAD_REQUEST);
		}

		List<School> result = studentService.getSchoolByIdAndClassId(schoolId, classId);
		if (result == null || result.isEmpty()) {
			return new ResponseEntity<>("No data found", HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
