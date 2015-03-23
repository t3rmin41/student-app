package com.student.management.system.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.system.dao.entity.StudentDao;
import com.student.management.system.dao.repository.StudentRepository;
import com.student.management.system.service.entity.Student;

@Service("studentMapper")
public class StudentMapperWithDao {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudentsFromRepo() {
		List<StudentDao> studentsDao = studentRepository.getAllStudents();
		List<Student> students = new ArrayList<Student>();
		for (StudentDao dao : studentsDao) {
			students.add(new Student(
									 dao.getId(),
									 dao.getName(),
									 dao.getSurname(),
									 dao.getBirthDate(),
									 dao.getCourseId()
									 ));
		}
		return students;
	}
	
	public Student getStudentByIdFromRepo(Long id) {
		StudentDao dao = studentRepository.getStudentById(id);
		return new Student(
						   dao.getId(),
						   dao.getName(),
						   dao.getSurname(),
						   dao.getBirthDate(),
						   dao.getCourseId()
						   );
	}
}
