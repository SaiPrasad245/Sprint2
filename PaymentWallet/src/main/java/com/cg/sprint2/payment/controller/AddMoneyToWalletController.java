package com.cg.sprint2.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint2.payment.service.AddMoneyToWalletService;

@RestController
public class AddMoneyToWalletController {

	@Autowired
	AddMoneyToWalletService amservice;

	public void setAmservice(AddMoneyToWalletService amservice) {
		this.amservice = amservice;
	}

	// Add Money To Wallet
	@GetMapping(value = "/addMoney/{mobileno}/{cdno}/{amt}", produces = "application/json")
	public ResponseEntity<String> addMoneyToWallet(@PathVariable double amt, @PathVariable long cdno, @PathVariable String mobileno) {
		return amservice.addMoneyToWalletFromCard(amt, cdno, mobileno);
		
	}	
}
