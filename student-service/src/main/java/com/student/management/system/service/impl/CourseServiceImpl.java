package com.student.management.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.system.service.CourseService;
import com.student.management.system.service.entity.Course;
import com.student.management.system.service.mapper.CourseMapperWithDao;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapperWithDao courseMapper;
	
	@Override
	public List<Course> getAllCourses() {
		return courseMapper.getAllCourses();
	}

	@Override
	public Course getCourseById(Long id) {
		return courseMapper.getCourseById(id);
	}

	@Override
	public List<Course> getCoursesByTime(Date startTime, Date endTime) {
		return courseMapper.getCoursesByTime(startTime, endTime);
	}

	@Override
	public List<Course> getCoursesByTimeWithOrder(Date startTime, Date endTime, String order) {
		return courseMapper.getCoursesByTimeWithOrder(startTime, endTime, order);
	}

}
