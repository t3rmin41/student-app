package com.student.management.system.service.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course extends DomainEntity {

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private String coursename;
	private Date startTime;
	private String startTimeFormatted;
	private Date endTime;
	private String endTimeFormatted;
	private String location;
	
	public Course(Long id) {
		super(id);
	}

	public Course(Long id, String coursename, String location) {
		this(id);
		this.coursename = coursename;
		this.location = location;
	}
	
	public Course(Long id, String coursename, Date startTime, Date endTime, String location) {
		this(id, coursename, location);
		this.startTime = startTime;
		this.startTimeFormatted = format.format(startTime);
		this.endTime = endTime;
		this.endTimeFormatted = format.format(endTime);
	}
	
	public Course(Long id, String coursename, String startTime, String endTime, String location) {
		this(id, coursename, location);
		try {
			this.startTime = format.parse(startTime);
			this.endTime = format.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.startTimeFormatted = startTime;
		this.startTimeFormatted = endTime;
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

	public String getStartTimeFormatted() {
		return startTimeFormatted;
	}

	public void setStartTimeFormatted(String startTimeFormatted) {
		this.startTimeFormatted = startTimeFormatted;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEndTimeFormatted() {
		return endTimeFormatted;
	}

	public void setEndTimeFormatted(String endTimeFormatted) {
		this.endTimeFormatted = endTimeFormatted;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
