package com.student.management.system.dao.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.management.system.dao.entity.StudentDao;

@Repository
public class StudentRepository {

	private List<StudentDao> studentListDao = new ArrayList<StudentDao>() {{
	    add(new StudentDao(1L, "John", "Smith", "1992-03-03", 2L));
	    add(new StudentDao(2L, "Marta", "Klever", "1991-05-11", 3L));
	    add(new StudentDao(1L, "Steve", "Harris", "1993-01-22", 1L));
	}};
	
	public List<StudentDao> getAllStudents() {
		return this.studentListDao;
	}
	
	public StudentDao getStudentById(Long id) {
		for (StudentDao student : this.studentListDao) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	}
}
