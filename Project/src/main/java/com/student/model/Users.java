package com.student.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("users")
public class Users {
	private String userId;
	private String userName;
	private String role;
	private String classCode;
	private String schoolId;
}
