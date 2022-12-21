package com.simplilearn.estorezone.admin.model;

import java.util.Date;

/**
 * User Model
 * @author Akshata
 *
 */
public class User {
	
	//user model attributes
	private int userId;
	private String email;
	private String passsword;
	private String fullName;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private String image;
	private Long contact;
	private Date addedOn;
	
	//default constructor
	public User() {
		
	}
    
	//parameterized constructor
	public User(int userId, String email, String passsword, String fullName, String street, String city, String state,
			String country, int pincode, String image, Long contact, Date addedOn) {
		super();
		this.userId = userId;
		this.email = email;
		this.passsword = passsword;
		this.fullName = fullName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.image = image;
		this.contact = contact;
		this.addedOn = addedOn;
	}
    
	
	//getters and setters method
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
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
		return "User [userId=" + userId + ", email=" + email + ", passsword=" + passsword + ", fullName=" + fullName
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + ", image=" + image + ", contact=" + contact + ", addedOn=" + addedOn + "]";
	}
}