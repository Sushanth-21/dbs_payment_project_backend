package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class TransferTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7899979431103635309L;
	@Id
	private String transferTypeCode;
	private String transferTypeDescription;
	public TransferTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTransferTypeCode() {
		return transferTypeCode;
	}
	public void setTransferTypeCode(String transferTypeCode) {
		this.transferTypeCode = transferTypeCode;
	}
	public String getTransferTypeDescription() {
		return transferTypeDescription;
	}
	public void setTransferTypeDescription(String transferTypeDescription) {
		this.transferTypeDescription = transferTypeDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(transferTypeCode, transferTypeDescription);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferTypes other = (TransferTypes) obj;
		return Objects.equals(transferTypeCode, other.transferTypeCode)
				&& Objects.equals(transferTypeDescription, other.transferTypeDescription);
	}
	@Override
	public String toString() {
		return "TransferTypes [transferTypeCode=" + transferTypeCode + ", transferTypeDescription="
				+ transferTypeDescription + "]";
	}
	public TransferTypes(String transferTypeCode, String transferTypeDescription) {
		super();
		this.transferTypeCode = transferTypeCode;
		this.transferTypeDescription = transferTypeDescription;
	}

}
