
  package com.cg.sprint2.payment.dto;
  
 import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
  
  @Entity
  
  @Table(name="transactiondetails")
  public class TransactionHistory
  {
	 
	  @Id
	  @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="transidseq")
	  @SequenceGenerator(sequenceName="transactionid_seq",allocationSize=1,name="transidseq")
	  @Column(name="Transid")
	  int transactionId;
	  String sender;
	  String reciever;
	  double amount;
	  @Column(name="sendermobileno")
	  String smobileno;
	  @Column(name="recievermobileno")
	  String rmobileno;
	 Date dateoftrans;
	public TransactionHistory(int transactionId, String sender, String reciever, double amount, String smobileno,
			String rmobileno, Date dateoftrans) {
		super();
		this.transactionId = transactionId;
		this.sender = sender;
		this.reciever = reciever;
		this.amount = amount;
		this.smobileno = smobileno;
		this.rmobileno = rmobileno;
		this.dateoftrans = dateoftrans;
	}
	public TransactionHistory() {
		super();
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSmobileno() {
		return smobileno;
	}
	public void setSmobileno(String smobileno) {
		this.smobileno = smobileno;
	}
	public String getRmobileno() {
		return rmobileno;
	}
	public void setRmobileno(String rmobileno) {
		this.rmobileno = rmobileno;
	}
	public Date getDateoftrans() {
		return dateoftrans;
	}
	public void setDateoftrans(Date dateoftrans) {
		this.dateoftrans = dateoftrans;
	}
  
	  
  }
 