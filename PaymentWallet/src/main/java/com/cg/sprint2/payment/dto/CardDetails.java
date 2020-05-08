package com.cg.sprint2.payment.dto;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="carddetails")
public class CardDetails {
	@Id
	@Column(name="mobile_no")
	@NotNull
	String mobile_no; 
	String cardholdername;
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
    String  upiid;
	 int upipin;
    
	public CardDetails() {
		super();
	}

	public CardDetails(@NotNull String mobile_no, String cardholdername, @NotNull long cardno, @NotNull String cardtype,
			@NotNull int cvv, @NotNull LocalDate expirydate, double cardbalance, String upiid, int upipin) {
		super();
		this.mobile_no = mobile_no;
		this.cardholdername = cardholdername;
		this.cardno = cardno;
		this.cardtype = cardtype;
		this.cvv = cvv;
		this.expirydate = expirydate;
		this.cardbalance = cardbalance;
		this.upiid = upiid;
		this.upipin = upipin;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getCardholdername() {
		return cardholdername;
	}

	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
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

	public String getUpiid() {
		return upiid;
	}

	public void setUpiid(String upiid) {
		this.upiid = upiid;
	}

	public int getUpipin() {
		return upipin;
	}

	public void setUpipin(int upipin) {
		this.upipin = upipin;
	}

	
}
