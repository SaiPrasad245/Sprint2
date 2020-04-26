package com.cg.sprint2.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.service.TransferAmountService;

@RestController
public class TransferAmountController {
	
	@Autowired
	
	TransferAmountService taservice;
	public void setTaservice(TransferAmountService taservice) {
		this.taservice = taservice;
	}
	//value= Transfer Amount From one Wallet Account to another  Wallet Account
	@GetMapping(value="/transferAmount/{smobileno}/{rmobileno}/{amt}")
	public void transferAmountToAnotherWallet(@PathVariable String smobileno,@PathVariable String rmobileno,@PathVariable double amt)
	{
		taservice.transferAmountToAnotherWallet(smobileno,rmobileno,amt);
	}

}
