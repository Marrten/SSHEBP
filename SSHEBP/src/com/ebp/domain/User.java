package com.ebp.domain;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String gender;
	private Date registerTime;
	private double balance = 0;
	
	public User() {
		super();
	}
	
	public User(int id) {
		super();
		this.id = id;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
	}
	public User(String username, String password, Date registerTime) {
		super();
		this.username = username;
		this.password = password;
		this.registerTime = registerTime;
	}
	public User(String name, String username, String password, String phone,
			String gender, Date registerTime, double balance) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.registerTime = registerTime;
		this.balance = balance;
	}


	public User(int id, String name, String username, String password,
			String phone, String gender, Date registerTime, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.registerTime = registerTime;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password="
				+ password + ", phone=" + phone + ", gender=" + gender
				+ ", registerTime=" + registerTime + ", balance=" + balance
				+ "]";
	}

}
