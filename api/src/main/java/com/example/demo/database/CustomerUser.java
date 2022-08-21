package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class CustomerUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -294691594747334469L;
	@Id
	private int userId;
	private String username;
	@OneToOne
	private Customer customer;
	private String password;
	public CustomerUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerUser(int userId, String username, Customer customer, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.customer = customer;
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerUser [userId=" + userId + ", username=" + username + ", customer=" + customer + ", password="
				+ password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer, password, userId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerUser other = (CustomerUser) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(password, other.password)
				&& userId == other.userId && Objects.equals(username, other.username);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
