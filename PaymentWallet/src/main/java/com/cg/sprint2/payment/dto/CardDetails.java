package com.cg.sprint2.payment.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="carddetails",schema="PRASAD")
public class CardDetails {
	@Id
	@Column(name="mobileno")
	@NotNull
	String mobileno;
	@Column(name="cardno")
	@NotNull
	long cardno;
	@Column(name="cardtype")
	@NotNull
	String cardtype;
	@Column(name="cvv")
	@NotNull
	int cvv;
	@Column(name="expirydate")
	@NotNull
	LocalDate expirydate;
	@Column(name="cbalance")
	double cardbalance=50000;
	
	public CardDetails() {
		super();
	}

	public CardDetails(String mobileno, long cardno, String cardtype, int cvv, LocalDate expirydate, double cardbalance) {
		super();
		this.mobileno = mobileno;
		this.cardno = cardno;
		this.cardtype = cardtype;
		this.cvv = cvv;
		this.expirydate = expirydate;
		this.cardbalance = cardbalance;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public long getCardno() {
		return cardno;
	}

	public void setCardno(long cardno) {
		this.cardno = cardno;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public double getCardbalance() {
		return cardbalance;
	}

	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}
	
	

}
