package com.student.management.system.service;

import java.util.Date;
import java.util.List;

import com.student.management.system.service.entity.Course;

public interface CourseService {

	public List<Course> getAllCourses();
	public Course getCourseById(Long id);
	public List<Course> getCoursesByTime(Date startTime, Date endTime);
	public List<Course> getCoursesByTimeWithOrder(Date startTime, Date endTime, String order);
	
}
