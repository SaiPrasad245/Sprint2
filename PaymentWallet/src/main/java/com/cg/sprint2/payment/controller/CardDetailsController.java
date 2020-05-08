package com.cg.sprint2.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint2.payment.dto.CardDetails;
import com.cg.sprint2.payment.service.CardDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CardDetailsController {

	@Autowired

	CardDetailsService cservice;

	// Add Card to the User
	@PostMapping(value = "/addcard/{mobileno}", consumes = "application/json")
	public ResponseEntity<String> addNewCard(@RequestBody CardDetails cdetails, @PathVariable String mobileno) {
		return cservice.addNewCard(cdetails, mobileno);
	}

	// Get All Added Cards By Mobileno
	@GetMapping(value = "/showAllCards/{mobileno}", produces = "application/json")
		public long  showAllCardsByMobileno(@PathVariable String mobileno)
	{
			Optional<CardDetails> cadDetailsList = cservice.getCarddetailsByMobileno(mobileno);
			return cadDetailsList.get().getCardno();
    }
	// Show All Cards
	@GetMapping(value="/showAllCards/", produces = "application/json")
	public List<CardDetails> showAllCards()
	{
			List<CardDetails> cadDetailsList =cservice.getCarddetails();
			return cadDetailsList;
    }
	// Show Card Balance
	@GetMapping(value="/showAccBalance/{mobileno}", produces="application/json")
	public double showAccountBalanceOfUser(@PathVariable String mobileno)
	{
		double cardbalance = cservice.showAccountBalanceOfUser(mobileno);
		return cardbalance;
		
	}
	// get UPI ID
	@GetMapping(value="/getUpiId/{mobileno}", produces="application/json")
	public String getUpiId(@PathVariable String mobileno)
	{
		String id = cservice.geUpi(mobileno);
		return id;
		
	}
	
}
