package com.cg.sprint2.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.service.ShowWalletBalanceService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ShowWalletBalanceController {

	@Autowired
	 ShowWalletBalanceService sservice;

	public void setSservice(ShowWalletBalanceService sservice) {
		this.sservice = sservice;
	}
	// Show Wallet Balance of the user
	@GetMapping(value="/walletBalance/{mobileno}")
	public double showWalletBalanceOfUser(@PathVariable String mobileno)
	{
		double balance=sservice.showWalletBalanceOfUser(mobileno);
		return balance;
	}
	
}
