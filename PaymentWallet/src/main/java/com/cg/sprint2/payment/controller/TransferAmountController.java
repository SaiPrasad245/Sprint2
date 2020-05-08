package com.cg.sprint2.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.service.TransferAmountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransferAmountController {
	
	@Autowired
	
	TransferAmountService taservice;
	public void setTaservice(TransferAmountService taservice) {
		this.taservice = taservice;
	}
	//Transfer Amount From one Wallet Account to another  Wallet Account
	@GetMapping(value="/transferAmount/{smobileno}/{rmobileno}/{amt}")
	public ResponseEntity<String> transferAmountToAnotherWallet(@PathVariable String smobileno,@PathVariable String rmobileno,@PathVariable double amt)
	{
		return taservice.transferAmountToAnotherWalletUser(smobileno,rmobileno,amt);
	}
	@GetMapping(value="/upiTransfer/{mobileno}/{upimobileno}/{pin}/{amount}")
public ResponseEntity<String> upiTransfer(@PathVariable String mobileno,@PathVariable String upimobileno,@PathVariable int pin,@PathVariable double amount)
   {
		return taservice.upiTransfer(mobileno, upimobileno, amount,pin);
	}

}
