
package com.cg.sprint2.payment.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.sprint2.payment.dao.AddMoneyToWalletDAO;
import com.cg.sprint2.payment.dto.CardDetails;

@Service
public class AddMoneyToWalletService {
	@Autowired
	
	 AddMoneyToWalletDAO amdao;
	
	
	
	  // Adding Card
	
	public CardDetails addcard(CardDetails card)
	{
		return amdao.save(card);
	}
	// Show All Cards
	
	 @Transactional(readOnly=true)
	public List<CardDetails> getCarddetailsByMobileno(String mobileno)
	{
		List<String> mb = new ArrayList<>();
		mb.add(mobileno);
		return amdao.findAllById(mb);
	}
	 //Add Money To Wallet
	 public void addMoney(double add,String mobileno)
	 {
		 
		  amdao.addToWallet(add,mobileno);
	 }
	  
		 // Deducting Amount From Card
		
		  public void dedcutBalance(double deduct,long cdno) {
			  amdao.deductBalance(deduct, cdno); }

		  
}


