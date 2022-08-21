package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Bank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4991796981496169590L;
	@Id
	private String bic;
	private String bankName;
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bankName, bic);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(bankName, other.bankName) && Objects.equals(bic, other.bic);
	}
	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankName=" + bankName + "]";
	}
	public Bank(String bic, String bankName) {
		super();
		this.bic = bic;
		this.bankName = bankName;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

}
