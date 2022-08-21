package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4783475477991175611L;
	@Id
	private String currencyCode;
	private String currencyName;
	private Long conversionRate;
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Currency(String currencyCode, String currencyName, Long conversionRate) {
		super();
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.conversionRate = conversionRate;
	}
	@Override
	public String toString() {
		return "Currency [currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", conversionRate="
				+ conversionRate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(conversionRate, currencyCode, currencyName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		return Objects.equals(conversionRate, other.conversionRate) && Objects.equals(currencyCode, other.currencyCode)
				&& Objects.equals(currencyName, other.currencyName);
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public Long getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(Long conversionRate) {
		this.conversionRate = conversionRate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
