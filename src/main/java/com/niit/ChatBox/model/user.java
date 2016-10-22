package com.niit.ChatBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userid;
	
	@NotNull
	@Size(min = 6, max = 14, message="name")
	@Column
	private String name;
	
	@Column
	@NotNull
	@Size(min = 6, max = 14, message="reason")
	private String reason;
	
	@Column
	@NotNull
	@Size(min = 6, max = 14, message="status")
	private String status;

	@Column
	@NotNull
	@Size(min = 6, max = 14, message="username")
	private String username;

	@Column
	@NotNull
	@Size(min = 6, max = 14, message="address")
	private String address;
	
	@Column
	@NotNull
	@Size(min = 6, max = 14, message="mail")
	private String mail;
	
	@Column
	@NotNull
	@Size(min = 6, max = 14, message="ph")
	private String ph;
	
	@Column
	@NotNull
	@Size(min = 6, max = 14, message="pwd")
	private String pwd;
	
	@Column
	@NotNull
	@Size(min = 6, max = 14, message="role")
	private String role;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



}
