package com.student.management.system.service;

import java.util.List;

import com.student.management.system.service.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	Student getStudentById(Long id);
}
