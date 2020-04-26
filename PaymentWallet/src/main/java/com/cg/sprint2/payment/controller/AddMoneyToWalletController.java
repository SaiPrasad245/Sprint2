package com.cg.sprint2.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint2.payment.dto.CardDetails;
import com.cg.sprint2.payment.dto.User;
import com.cg.sprint2.payment.service.AddMoneyToWalletService;
import com.cg.sprint2.payment.service.CardDetailsService;
import com.cg.sprint2.payment.service.UserService;

@RestController
public class AddMoneyToWalletController {

	@Autowired
	AddMoneyToWalletService amservice;

	public void setAmservice(AddMoneyToWalletService amservice) {
		this.amservice = amservice;
	}

	CardDetailsService cservice;

	public void setCservice(CardDetailsService cservice) {
		this.cservice = cservice;
	}
	
	UserService uservice;
	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}
	// Add Card to the User
	@PostMapping(value = "/addcard/{mobileno}", consumes = "application/json")
	public ResponseEntity<String> addNewCard(@RequestBody CardDetails cdetails, @PathVariable String mobileno) {
		cdetails.setMobileno(mobileno);
		String smsg = "Card Added";
		String umsg = "Card Addition Failed";

		if (amservice.addcard(cdetails) != null) {
			return new ResponseEntity<String>(smsg, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(umsg, HttpStatus.BAD_REQUEST);
		}
	}

	// Get All Added Cards
	@GetMapping(value = "/showAllCards/{mobileno}", produces = "application/json")
	public List<CardDetails> showAllCards(@PathVariable String mobileno) {
		List<CardDetails> cadDetailsList = amservice.getCarddetailsByMobileno(mobileno);
		for (CardDetails cardDetails : cadDetailsList) {
			System.out.println(cardDetails.getCardno());
			System.out.println(cardDetails.getCvv());

		}
		return cadDetailsList;
	}

	// Add Money To Wallet
	@GetMapping(value = "/addMoney/{mobileno}/{cdno}/{add}", produces = "application/json")
	public String addMoneyToWallet(@PathVariable double add, @PathVariable long cdno, @PathVariable String mobileno) {
		List<CardDetails> cd = amservice.getCarddetailsByMobileno(mobileno);
		String msg="";
		for (CardDetails cardDetails : cd) {
			System.out.println(cardDetails.getCardno());
			if (cdno == cardDetails.getCardno()) {
				System.out.println("Card Found" + cardDetails.getCardbalance());

				if (add < cardDetails.getCardbalance()) {
					System.out.println("true");
					amservice.dedcutBalance(add, cdno);
					amservice.addMoney(add, mobileno);
					 msg="Money Added Sucessfully";
				} else
					msg="Insufficient Balance";

			} else
				msg= "Card Not Found";
		}
		return msg;
	}
	@GetMapping(value="/showWalletBalance/{mobileno}",produces="application/json")
	public ResponseEntity<String> showWalletBalance(@PathVariable String mobileno)
	{
		System.out.println("");
		Optional<User> u=uservice.validateLogin(mobileno);
		System.out.println(u.get().getWalletbalance());
		//return u.get().getWalletbalance();
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
}
