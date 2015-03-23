package com.student.management.system.dao.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CourseDao extends DaoEntity {
	
	public static final Comparator<CourseDao> ASC_CASE_INSENSITIVE = new Comparator<CourseDao>() {
		public int compare(CourseDao d1, CourseDao d2) {
			return d1.coursename.compareTo(d2.coursename);
		}
	};
	

	public static final Comparator<CourseDao> DESC_CASE_INSENSITIVE = new Comparator<CourseDao>() {
		public int compare(CourseDao d1, CourseDao d2) {
			return d2.coursename.compareTo(d1.coursename);
		}
	};
	
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private String coursename;
	private Date startTime;
	private Date endTime;
	private String location;
	
	public CourseDao(Long id) {
		super(id);
	}

	public CourseDao(Long id, String coursename, String location) {
		this(id);
		this.coursename = coursename;
		this.location = location;
	}
	
	public CourseDao(Long id, String coursename, Date startTime, Date endTime, String location) {
		this(id, coursename, location);
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public CourseDao(Long id, String coursename, String startTime, String endTime, String location) {
		this(id, coursename, location);
		try {
			this.startTime = format.parse(startTime);
			this.endTime = format.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
