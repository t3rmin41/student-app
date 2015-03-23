package com.student.management.system.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.management.system.service.StudentService;
import com.student.management.system.service.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/page")
	public String studentsPage(Model model) {
		return prepareStudentListForReview(model);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json; charset=utf-8","application/xml; charset=utf-8"})
	public @ResponseBody List<Student> studentList(@RequestBody Map<String,String> searchCriteria) {
		if (searchCriteria.get("quantity").equals("all")) {
			return studentService.getAllStudents();
		} else {
			return null;
		}
	}
	
	private String prepareStudentListForReview(Model model) {
		return "student/studentsPage";
	}
}
