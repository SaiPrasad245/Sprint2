
package com.cg.sprint2.payment.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint2.payment.dao.AddMoneyToWalletDAO;
import com.cg.sprint2.payment.dto.CardDetails;

@Service
public class AddMoneyToWalletService {
	@Autowired
	
	 AddMoneyToWalletDAO amdao;
	
	public void setAmdao(AddMoneyToWalletDAO amdao) {
		this.amdao = amdao;
	}
	
	// Show All Cards
		@Transactional(readOnly = true)
		public List<CardDetails> getCarddetailsByMobileno(String mobileno) {
			List<String> mb = new ArrayList<>();
			mb.add(mobileno);
			return amdao.findAllById(mb);
		}
	
	//Add Money To Wallet from card QUERY
	 public void addMoney(double add,String mobileno)
	 {  amdao.addToWallet(add,mobileno); }
	   // Deducting Amount From Card  QUERY
	public void dedcutBalance(double deduct,long cdno) {
			  amdao.deductBalance(deduct, cdno); }


	
	//adding money from wallet to card and deducting amount from card operation
	public  ResponseEntity<String>  addMoneyToWalletFromCard(double amt,long cdno,String mobileno)
	{
		List<CardDetails> cd = getCarddetailsByMobileno(mobileno);
		String msg="";
		for (CardDetails cardDetails : cd) {
			if (cdno == cardDetails.getCardno())
			 {
				if (amt < cardDetails.getCardbalance()) {
					dedcutBalance(amt, cdno);
					addMoney(amt, mobileno);
					 msg="Money Added Sucessfully";
					 return new ResponseEntity<String>(msg,HttpStatus.OK);
				} else
					msg="Insufficient Balance";
				return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);

			} else
				msg= "Card Not Found";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	 }
}


