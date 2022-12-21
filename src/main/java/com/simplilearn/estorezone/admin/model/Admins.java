package com.simplilearn.estorezone.admin.model;

import java.util.Date;

/**
 * Admin Model
 * @author Akshata
 *
 */

public class Admins {
	
	//admins model attributes
	private int adminId;
	private String email;
	private String password;
	private String fullName;
	private int longType;
	private Date addedOn;
	
	//default constructor
	public Admins() {
		
	}
    
	//parameterized constructor
	public Admins(int adminId, String email, String password, String fullName, int longType, Date addedOn) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.longType = longType;
		this.addedOn = addedOn;
	}
    
	//getter and setter methods
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getLongType() {
		return longType;
	}

	public void setLongType(int longType) {
		this.longType = longType;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	
	//override to string
	@Override
	public String toString() {
		return "Admins [adminId=" + adminId + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", longType=" + longType + ", addedOn=" + addedOn + "]";
	}	

}
