package com.ebp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Adminuser implements Serializable {

	private static final long serialVersionUID = 9097920310259706343L;
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	
	public Adminuser() {
		super();
	}
	
	public Adminuser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Adminuser(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Adminuser [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
}
