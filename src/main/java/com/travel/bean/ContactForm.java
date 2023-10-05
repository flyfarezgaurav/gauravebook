package com.travel.bean;

public class ContactForm {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String message;
	private String capchaCode;
	
	public String getCapchaCode() {
		return capchaCode;
	}
	public void setCapchaCode(String capchaCode) {
		this.capchaCode = capchaCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
