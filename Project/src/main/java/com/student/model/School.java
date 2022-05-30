package com.student.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Document("school")
@Data
@Getter
@Setter
public class School {
	private String schoolId;
	private String schoolName;
	private ClassDetails classDetails;
}
