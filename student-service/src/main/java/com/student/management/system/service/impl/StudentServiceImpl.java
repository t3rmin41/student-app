package com.student.management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.system.service.StudentService;
import com.student.management.system.service.entity.Student;
import com.student.management.system.service.mapper.StudentMapperWithDao;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapperWithDao studentMapper;
	
	@Override
	public List<Student> getAllStudents() {
		return studentMapper.getAllStudentsFromRepo();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentMapper.getStudentByIdFromRepo(id);
	}

}
