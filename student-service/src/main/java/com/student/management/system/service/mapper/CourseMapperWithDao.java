package com.student.management.system.service.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.system.dao.entity.CourseDao;
import com.student.management.system.dao.repository.CourseRepository;
import com.student.management.system.service.entity.Course;

@Service("courseMapper")
public class CourseMapperWithDao {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> tmpList = new ArrayList<Course>();
		List<CourseDao> daoList = courseRepository.getAllCourses();
		for (CourseDao dao : daoList) {
			tmpList.add(new Course(
								   dao.getId(),
								   dao.getCoursename(),
								   dao.getStartTime(),
								   dao.getEndTime(),
								   dao.getLocation()
								   ));
		}
		return tmpList;
	}
	
	public Course getCourseById(Long id) {
		CourseDao dao = courseRepository.getCourseDaoById(id);
		return new Course(dao.getId(), dao.getCoursename(), dao.getStartTime(), dao.getEndTime(), dao.getLocation());
	}
	
	public List<Course> getCoursesByTime(Date startTime, Date endTime) {
		List<Course> tmpList = new ArrayList<Course>();
		List<CourseDao> daoList = courseRepository.getCoursesByTime(startTime, endTime);
		for (CourseDao dao : daoList) {
			tmpList.add(new Course(
								   dao.getId(),
								   dao.getCoursename(),
								   dao.getStartTime(),
								   dao.getEndTime(),
								   dao.getLocation()
								   ));
		}
		return tmpList;

	}
	
	public List<Course> getCoursesByTimeWithOrder(Date startTime, Date endTime, String order) {
		List<Course> tmpList = new ArrayList<Course>();
		List<CourseDao> daoList = courseRepository.getCoursesByTimeWithOrder(startTime, endTime, order);
		for (CourseDao dao : daoList) {
			tmpList.add(new Course(
								   dao.getId(),
								   dao.getCoursename(),
								   dao.getStartTime(),
								   dao.getEndTime(),
								   dao.getLocation()
								   ));
		}
		return tmpList;
	}
	
}
