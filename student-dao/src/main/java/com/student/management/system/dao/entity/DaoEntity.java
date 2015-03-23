package com.student.management.system.dao.entity;

public abstract class DaoEntity {

	private Long id;

	public DaoEntity(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
