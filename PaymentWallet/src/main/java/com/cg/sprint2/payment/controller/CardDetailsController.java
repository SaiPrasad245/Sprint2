package com.cg.sprint2.payment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint2.payment.dto.CardDetails;
import com.cg.sprint2.payment.service.CardDetailsService;

@RestController
public class CardDetailsController {

	@Autowired

	CardDetailsService cservice;

	// Add Card to the User
	@PostMapping(value = "/addcard/{mobileno}", consumes = "application/json")
	public ResponseEntity<String> addNewCard(@RequestBody CardDetails cdetails, @PathVariable String mobileno) {
		return cservice.addNewCard(cdetails, mobileno);
	}

	// Get All Added Cards
	@GetMapping(value = "/showAllCards/{mobileno}", produces = "application/json")
		public List<CardDetails> showAllCards(@PathVariable String mobileno)
	{
			List<CardDetails> cadDetailsList = cservice.getCarddetailsByMobileno(mobileno);
			return cadDetailsList;
    }
}
