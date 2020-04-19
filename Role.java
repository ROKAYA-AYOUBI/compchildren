package com.manager.CampChildreanHolydayManager.Entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {
	@Id
	public String role;
	public String description;
	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
