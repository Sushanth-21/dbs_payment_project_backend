package com.example.demo.database;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3152616012326302400L;
	@Id
	private String messageCode;
	private String instruction;
	@Override
	public int hashCode() {
		return Objects.hash(instruction, messageCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(instruction, other.instruction) && Objects.equals(messageCode, other.messageCode);
	}
	@Override
	public String toString() {
		return "Message [messageCode=" + messageCode + ", instruction=" + instruction + "]";
	}
	public Message(String messageCode, String instruction) {
		super();
		this.messageCode = messageCode;
		this.instruction = instruction;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
