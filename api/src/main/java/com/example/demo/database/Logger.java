package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Logger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2092535826019279511L;
	@Id
	private Long loggerId;
	@ManyToOne
	private Customer customerId;
	@ManyToOne
	private CustomerUser userId;
	@ManyToOne
	private Employee employeeId;
	private String screenName;
	private String action;
	private String ipAddress;
	public Logger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logger(Long loggerId, Customer customerId, CustomerUser userId, Employee employeeId, String screenName,
			String action, String ipAddress) {
		super();
		this.loggerId = loggerId;
		this.customerId = customerId;
		this.userId = userId;
		this.employeeId = employeeId;
		this.screenName = screenName;
		this.action = action;
		this.ipAddress = ipAddress;
	}
	@Override
	public String toString() {
		return "Logger [loggerId=" + loggerId + ", customerId=" + customerId + ", userId=" + userId + ", employeeId="
				+ employeeId + ", screenName=" + screenName + ", action=" + action + ", ipAddress=" + ipAddress + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(action, customerId, employeeId, ipAddress, loggerId, screenName, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logger other = (Logger) obj;
		return Objects.equals(action, other.action) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(ipAddress, other.ipAddress)
				&& Objects.equals(loggerId, other.loggerId) && Objects.equals(screenName, other.screenName)
				&& Objects.equals(userId, other.userId);
	}
	public Long getLoggerId() {
		return loggerId;
	}
	public void setLoggerId(Long loggerId) {
		this.loggerId = loggerId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public CustomerUser getUserId() {
		return userId;
	}
	public void setUserId(CustomerUser userId) {
		this.userId = userId;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
