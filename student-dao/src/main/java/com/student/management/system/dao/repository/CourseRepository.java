package com.student.management.system.dao.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.management.system.dao.entity.CourseDao;

@Repository
public class CourseRepository {
	
	private List<CourseDao> courseDaoList = new ArrayList<CourseDao>() {{
		add(new CourseDao(1L, "Medicine", "2015-09-02", "2016-05-02", "Harvard"));
		add(new CourseDao(3L, "Economics", "2016-10-01", "2017-06-01", "Yale"));
		add(new CourseDao(4L, "Financial markets", "2017-11-02", "2018-07-02", "Stanford"));
		add(new CourseDao(5L, "Politics", "2019-12-01", "2020-04-01", "Harvard"));
		add(new CourseDao(2L, "Maths", "2015-09-01", "2016-05-01", "Berkeley" ));
	}};
	
	public List<CourseDao> getAllCourses() {
		return this.courseDaoList;
	}
	
	public CourseDao getCourseDaoById(Long id) {
		for (CourseDao dao : this.courseDaoList) {
			if (dao.getId().equals(id)) {
				return dao;
			}
		}
		return null;
	}
	
	public List<CourseDao> getCoursesByTime(Date startTime, Date endTime) {
		List<CourseDao> tmpList = new ArrayList<CourseDao>();
		for (CourseDao dao : this.courseDaoList) {
			if (dao.getStartTime().after(startTime) && dao.getEndTime().before(endTime)) {
				tmpList.add(dao);
			}
		}
		return tmpList;
	}
	
	public List<CourseDao> getCoursesByTimeWithOrder(Date startTime, Date endTime, String order) {
		List tmpDaoList = getCoursesByTime(startTime, endTime);
		if ("asc".equals(order)) {
			Collections.sort(tmpDaoList, CourseDao.ASC_CASE_INSENSITIVE);
		} else if ("desc".equals(order)) {
			Collections.sort(tmpDaoList, CourseDao.DESC_CASE_INSENSITIVE);
		}
		return tmpDaoList;
	}
}
