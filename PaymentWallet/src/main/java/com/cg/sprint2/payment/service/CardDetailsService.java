package com.cg.sprint2.payment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint2.payment.dao.CardDetailsDAO;



@Service
public class CardDetailsService {

	@Autowired
	CardDetailsDAO cdao;

	public void setCdao(CardDetailsDAO cdao) {
		this.cdao=cdao;
	}
	
	
		 
}
