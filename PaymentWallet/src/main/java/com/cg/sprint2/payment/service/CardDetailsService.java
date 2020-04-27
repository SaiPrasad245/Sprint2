package com.cg.sprint2.payment.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<CardDetails> getCarddetailsByMobileno(String mobileno) {
		List<String> mb = new ArrayList<>();
		mb.add(mobileno);
		return cdao.findAllById(mb);
	}

	// Adding Card To The User
	public ResponseEntity<String> addNewCard(CardDetails cdetails, String mobileno) {
		cdetails.setMobileno(mobileno);
		List<CardDetails> cd=getCarddetails();
		for (CardDetails cdet : cd) 
		{
			if(((cdet.getCardno()==cdetails.getCardno())&&(cdet.getCvv()==cdetails.getCvv())&&(cdet.getExpirydate()==cdetails.getExpirydate())))
			{
				System.out.println(cdetails.getCardbalance());
				cdetails.setCardbalance(cdet.getCardbalance());
				System.out.println(cdetails.getCardbalance());
				addcard(cdetails);
				String smsg = "Card Added";
			    return new ResponseEntity<String>(smsg, HttpStatus.ACCEPTED);
				
			}
		}
		addcard(cdetails);
		String smsg = "Card Added";
	    return new ResponseEntity<String>(smsg, HttpStatus.OK);
	}
}
