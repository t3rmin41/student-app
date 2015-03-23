package com.student.management.system.dao.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentDao extends DaoEntity {

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private String name;
	private String surname;
	private Date birthDate;
	private Long courseId;
	
	public StudentDao(Long id) {
		super(id);
	}
	
	public StudentDao(Long id, String name, String surname) {
		this(id);
		this.name = name;
		this.surname = surname;
	}
	
	public StudentDao(Long id, String name, String surname, Date birthDate, Long courseId) {
		this(id, name, surname);
		this.birthDate = birthDate;
		this.courseId = courseId;
	}
	
	public StudentDao(Long id, String name, String surname, String birthDate, Long courseId) {
		this(id, name, surname);
		try {
			this.birthDate = format.parse(birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
}
