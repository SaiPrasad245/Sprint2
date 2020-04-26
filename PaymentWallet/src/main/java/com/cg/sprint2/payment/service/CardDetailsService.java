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
	public List<CardDetails> getCarddetailsByMobileno(String mobileno) {
		List<String> mb = new ArrayList<>();
		mb.add(mobileno);
		return cdao.findAllById(mb);
	}

	// Adding Card To The User
	public ResponseEntity<String> addNewCard(CardDetails cdetails, String mobileno) {
		cdetails.setMobileno(mobileno);
		String smsg = "Card Added";
		String umsg = "Card Addition Failed";

		if (addcard(cdetails) != null) {
			return new ResponseEntity<String>(smsg, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(umsg, HttpStatus.BAD_REQUEST);
		}
	}
}
