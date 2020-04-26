package com.cg.sprint2.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.service.ShowWalletBalanceService;



@RestController
public class ShowWalletBalanceController {

	@Autowired
	 ShowWalletBalanceService sservice;

	public void setSservice(ShowWalletBalanceService sservice) {
		this.sservice = sservice;
	}
	
	@GetMapping(value="/walletBalance/{mobileno}")
	public double showWalletBalanceOfUser(@PathVariable String mobileno)
	{
		double balance=sservice.showWalletBalanceOfUser(mobileno);
		return balance;
	}
	
}
