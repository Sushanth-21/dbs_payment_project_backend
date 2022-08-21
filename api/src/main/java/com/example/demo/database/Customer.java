package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1636411575383408040L;
	@Id
	private String customerId;
	private String accountHolderName;
	private int overdraftflag;
	private Long clearBalance;
	private String customerAddress;
	private String customerCity;
	private String customerType;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountHolderName, clearBalance, customerAddress, customerCity, customerId, customerType,
				overdraftflag);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accountHolderName, other.accountHolderName)
				&& Objects.equals(clearBalance, other.clearBalance)
				&& Objects.equals(customerAddress, other.customerAddress)
				&& Objects.equals(customerCity, other.customerCity) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerType, other.customerType) && overdraftflag == other.overdraftflag;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", accountHolderName=" + accountHolderName + ", overdraftflag="
				+ overdraftflag + ", clearBalance=" + clearBalance + ", customerAddress=" + customerAddress
				+ ", customerCity=" + customerCity + ", customerType=" + customerType + "]";
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerId, String accountHolderName, int overdraftflag, Long clearBalance,
			String customerAddress, String customerCity, String customerType) {
		super();
		this.customerId = customerId;
		this.accountHolderName = accountHolderName;
		this.overdraftflag = overdraftflag;
		this.clearBalance = clearBalance;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerType = customerType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getOverdraftflag() {
		return overdraftflag;
	}
	public void setOverdraftflag(int overdraftflag) {
		this.overdraftflag = overdraftflag;
	}
	public Long getClearBalance() {
		return clearBalance;
	}
	public void setClearBalance(Long clearBalance) {
		this.clearBalance = clearBalance;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
