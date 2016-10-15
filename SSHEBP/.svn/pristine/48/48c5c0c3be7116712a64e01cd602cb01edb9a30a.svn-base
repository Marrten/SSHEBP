package com.ebp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Orders implements Serializable {

	private static final long serialVersionUID = -6335079778886960455L;
	
	@Id
	private String id;
	private String orderNum;
	private Date createTime;
	private double price;
	private int delete_id;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="orders")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Item> items = new ArrayList<Item>();

	public Orders() {
		super();
	}

	public Orders(String orderNum, Date createTime, double price) {
		super();
		this.orderNum = orderNum;
		this.createTime = createTime;
		this.price = price;
	}
	
	public Orders(String id, String orderNum, Date createTime, double price) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.createTime = createTime;
		this.price = price;
	}

	/**
	 * 
	 * @param wangjiafu
	 */
	public Orders(String id, String orderNum, Date createTime, double price,
			User user) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.createTime = createTime;
		this.price = price;
		this.user = user;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getDelete_id() {
		return delete_id;
	}

	public void setDelete_id(int delete_id) {
		this.delete_id = delete_id;
	}

}
