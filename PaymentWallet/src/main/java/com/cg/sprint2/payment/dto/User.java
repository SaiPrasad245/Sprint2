package com.cg.sprint2.payment.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="walletuser")
 public class User
{
	String name;
	@Id
	String mobileno;
	String password;
	String email;
	double walletbalance=0;

	public User() {
		super();
	}

	public User(String name, String mobileno, String password, String email, double walletbalance)
	{
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.password = password;
		this.email = email;
		this.walletbalance = walletbalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getWalletbalance() {
		return walletbalance;
	}

	public void setWalletbalance(double walletbalance) {
		this.walletbalance = walletbalance;
	}
}