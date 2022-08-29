package com.example.demo.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4477626537343285510L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;
	@ManyToOne
	private Customer customerId;
	@ManyToOne
	private Currency currencyCode;
	@ManyToOne
	private Bank senderBIC;
	@ManyToOne
	private Bank receiverBIC;
	private String receiverAccountHolderNumber;
	private String receiverAccountHolderName;
	@ManyToOne
	private TransferTypes transferTypeCode;
	@ManyToOne
	private Message messageCode;
	private Long currencyAmount;
	@Column(precision = 10, scale = 2)
	private Double transferFees;
	private Long inrAmount;
	private LocalDateTime transferDate;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(Long transactionId, Customer customerId, Currency currencyCode, Bank senderBIC, Bank receiverBIC,
			String receiverAccountHolderNumber, String receiverAccountHolderName, TransferTypes transferTypeCode,
			Message messageCode, Long currencyAmount, Double transferFees, Long inrAmount, LocalDateTime transferDate) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.currencyCode = currencyCode;
		this.senderBIC = senderBIC;
		this.receiverBIC = receiverBIC;
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
		this.receiverAccountHolderName = receiverAccountHolderName;
		this.transferTypeCode = transferTypeCode;
		this.messageCode = messageCode;
		this.currencyAmount = currencyAmount;
		this.transferFees = transferFees;
		this.inrAmount = inrAmount;
		this.transferDate = transferDate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", currencyCode="
				+ currencyCode + ", senderBIC=" + senderBIC + ", receiverBIC=" + receiverBIC
				+ ", receiverAccountHolderNumber=" + receiverAccountHolderNumber + ", receiverAccountHolderName="
				+ receiverAccountHolderName + ", transferTypeCode=" + transferTypeCode + ", messageCode=" + messageCode
				+ ", currencyAmount=" + currencyAmount + ", transferFees=" + transferFees + ", inrAmount=" + inrAmount
				+ ", transferDate=" + transferDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(currencyAmount, currencyCode, customerId, inrAmount, messageCode, receiverAccountHolderName,
				receiverAccountHolderNumber, receiverBIC, senderBIC, transactionId, transferDate, transferFees,
				transferTypeCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(currencyAmount, other.currencyAmount) && Objects.equals(currencyCode, other.currencyCode)
				&& Objects.equals(customerId, other.customerId) && Objects.equals(inrAmount, other.inrAmount)
				&& Objects.equals(messageCode, other.messageCode)
				&& Objects.equals(receiverAccountHolderName, other.receiverAccountHolderName)
				&& Objects.equals(receiverAccountHolderNumber, other.receiverAccountHolderNumber)
				&& Objects.equals(receiverBIC, other.receiverBIC) && Objects.equals(senderBIC, other.senderBIC)
				&& Objects.equals(transactionId, other.transactionId)
				&& Objects.equals(transferDate, other.transferDate) && Objects.equals(transferFees, other.transferFees)
				&& Objects.equals(transferTypeCode, other.transferTypeCode);
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Currency getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(Currency currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Bank getSenderBIC() {
		return senderBIC;
	}
	public void setSenderBIC(Bank senderBIC) {
		this.senderBIC = senderBIC;
	}
	public Bank getReceiverBIC() {
		return receiverBIC;
	}
	public void setReceiverBIC(Bank receiverBIC) {
		this.receiverBIC = receiverBIC;
	}
	public String getReceiverAccountHolderNumber() {
		return receiverAccountHolderNumber;
	}
	public void setReceiverAccountHolderNumber(String receiverAccountHolderNumber) {
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
	}
	public String getReceiverAccountHolderName() {
		return receiverAccountHolderName;
	}
	public void setReceiverAccountHolderName(String receiverAccountHolderName) {
		this.receiverAccountHolderName = receiverAccountHolderName;
	}
	public TransferTypes getTransferTypeCode() {
		return transferTypeCode;
	}
	public void setTransferTypeCode(TransferTypes transferTypeCode) {
		this.transferTypeCode = transferTypeCode;
	}
	public Message getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(Message messageCode) {
		this.messageCode = messageCode;
	}
	public Long getCurrencyAmount() {
		return currencyAmount;
	}
	public void setCurrencyAmount(Long currencyAmount) {
		this.currencyAmount = currencyAmount;
	}
	public Double getTransferFees() {
		return transferFees;
	}
	public void setTransferFees(Double transferFees) {
		this.transferFees = transferFees;
	}
	public Long getInrAmount() {
		return inrAmount;
	}
	public void setInrAmount(Long inrAmount) {
		this.inrAmount = inrAmount;
	}
	public LocalDateTime getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(LocalDateTime transferDate) {
		this.transferDate = transferDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
