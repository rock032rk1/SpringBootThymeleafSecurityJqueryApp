package com.spring.app.model;

import java.sql.Date;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student_db20_security")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String mobile;
	private String email;
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String password;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String mobile, String email, Date dob, String password) {
		super();
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", mobile=" + mobile + ", email=" + email + ", dob="
				+ dob + ", password=" + password + "]";
	}

}
