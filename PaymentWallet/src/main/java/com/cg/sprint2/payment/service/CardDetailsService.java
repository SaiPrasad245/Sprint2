package com.cg.sprint2.payment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint2.payment.dao.CardDetailsDAO;
import com.cg.sprint2.payment.dto.CardDetails;

@Service
public class CardDetailsService {

	@Autowired
	CardDetailsDAO cdao;

	public void setCdao(CardDetailsDAO cdao) {
		this.cdao = cdao;
	}

	// Adding Card
	public CardDetails addcard(CardDetails card) {
		return cdao.save(card);
	}
	
	// Show All Cards
	@Transactional(readOnly = true)
	public List<CardDetails> getCarddetails() {
		return cdao.findAll();
		
			
	}

	// Show All Cards By Mobileno
	@Transactional(readOnly = true)
	public Optional<CardDetails> getCarddetailsByMobileno(String mobileno) {
		List<String> mb = new ArrayList<>();
		mb.add(mobileno);
		return cdao.findById(mobileno);
	}

	// Adding Card To The User
	public ResponseEntity<String> addNewCard(CardDetails cdetails, String mobileno) {
		cdetails.setMobile_no(mobileno);
		List<CardDetails> cd=getCarddetails();
		for (CardDetails cdet : cd) 
		{
			if((cdet.getCardno()==cdetails.getCardno()))
			{
				cdetails.setUpiid(cdet.getUpiid());
				cdetails.setCardbalance(cdet.getCardbalance());
				addcard(cdetails);
				String smsg = "Card Added";
			    return new ResponseEntity<String>(smsg, HttpStatus.ACCEPTED);
				
			}
		}
		addcard(cdetails);
		String smsg = "Card Added";
	    return new ResponseEntity<String>(smsg, HttpStatus.OK);
	}
	// Show Card Balance
	public double showAccountBalanceOfUser(String mobileno)
	{
		CardDetails u =cdao.findById(mobileno).get();
		return u.getCardbalance();
		
	}
	// Get UPI ID
	public String geUpi(String mobileno)
	{
		CardDetails u =cdao.findById(mobileno).get();
		return u.getUpiid(); 	
	}
}
