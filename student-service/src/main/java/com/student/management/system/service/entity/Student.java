package com.student.management.system.service.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends DomainEntity {

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private String name;
	private String surname;
	private Date birthDate;
	private String birthDateFormatted;
	private Long courseId;
	
	public Student(Long id) {
		super(id);
	}
	
	public Student(Long id, String name, String surname) {
		this(id);
		this.name = name;
		this.surname = surname;
	}

	public Student(Long id, String name, String surname, Date birthDate, Long courseId) {
		this(id, name, surname);
		this.birthDate = birthDate;
		this.birthDateFormatted = format.format(birthDate);
		this.courseId = courseId;
	}
	
	public Student(Long id, String name, String surname, String birthDate, Long courseId) {
		this(id, name, surname);
		try {
			this.birthDate = format.parse(birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.courseId = courseId;
		this.birthDateFormatted = birthDate;
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
	
	public String getBirthDateFormatted() {
		return birthDateFormatted;
	}

	public void setBirthDateFormatted(String birthDateFormatted) {
		this.birthDateFormatted = birthDateFormatted;
	}

	public Long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
