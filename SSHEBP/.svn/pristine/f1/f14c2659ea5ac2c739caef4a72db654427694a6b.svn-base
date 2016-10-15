package com.ebp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category implements Serializable{

	private static final long serialVersionUID = -303209786653043988L;
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="parent")
	private Set<Category> subCategory = new HashSet<Category>(); 
	
	@ManyToOne
	private Category parent;
	
	public Category() {
		super();
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<Category> subCategory) {
		this.subCategory = subCategory;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

}
