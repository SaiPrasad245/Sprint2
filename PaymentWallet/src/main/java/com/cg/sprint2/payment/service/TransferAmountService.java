package com.cg.sprint2.payment.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.sprint2.payment.dao.CardDetailsDAO;
import com.cg.sprint2.payment.dao.TransactionHistoryDAO;
import com.cg.sprint2.payment.dao.TransferAmountDAO;
import com.cg.sprint2.payment.dto.CardDetails;
import com.cg.sprint2.payment.dto.TransactionHistory;
import com.cg.sprint2.payment.dto.User;

@Service
public class TransferAmountService {

	@Autowired
	TransferAmountDAO tadao;
	
	@Autowired
	TransactionHistoryDAO thdao;
	@Autowired
	CardDetailsDAO cdao;

	public void setTadao(TransferAmountDAO tadao) {
		this.tadao = tadao;
	}
          // Transfer of Wallet Amount From one User To Another User
	public ResponseEntity<String> transferAmountToAnotherWalletUser(String smobileno, String rmobileno, double amt) 
	{
		String status="Transaction Done Through Wallet";
		String msg="";
			Optional<User> u = tadao.findById(smobileno);
			if(tadao.findById(rmobileno).isPresent())
			{
				if(amt<u.get().getWalletbalance())
				{
					msg="Amount Transferred";
					tadao.deductFromSenderWallet(amt, smobileno);
					tadao.addToReciverWallet(amt, rmobileno);
					transactionDetails(smobileno, rmobileno, amt,status);
					return new ResponseEntity<String>(msg,HttpStatus.OK);
				}
				else {
				   msg="Insufficient Balance";
				return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			    }
			}
			else
				msg="The Number that the money is to be sent has to be Registerd on the Application";
				return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	}	
	    // Saving the transaction in database
	public void transactionDetails(String smobileno,String rmobileno,double amt,String status)
	{
		
		
		Optional<User> sentuser = tadao.findById(smobileno);
		Optional<User> recieveduser = tadao.findById(rmobileno);
		 TransactionHistory th= new TransactionHistory();
		 th.setSender(sentuser.get().getName());
		 th.setReciever(recieveduser.get().getName());
		 th.setAmount(amt);
		 th.setSmobileno(smobileno);
		 th.setRmobileno(rmobileno);
		 LocalDate date = LocalDate.now();
	    	Date transdate = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	    	th.setDateoftrans(transdate);
	     th.setStatus(status);
	    thdao.save(th);
	}
	// transfer Through UPI
	public ResponseEntity<String> upiTransfer(String mobileno, String upimobileno, double amt,int pin) 
	{
		String status="Transaction Done Through UPI";
		String msg="";
			Optional<CardDetails> u = cdao.findById(mobileno);
			Optional<CardDetails> r = cdao.findById(upimobileno);
			String id =u.get().getUpiid();
			String id2 = r.get().getUpiid();
			if(cdao.findById(upimobileno).isPresent()&&(pin==u.get().getUpipin()))
			{
				if(amt<u.get().getCardbalance())
				{
					msg="Amount Transferred";
					cdao.deductFromSenderUpi(amt, id);
				    cdao.addToReciverUpi(amt, id2);
					transactionDetails(mobileno,upimobileno, amt,status);
					return new ResponseEntity<String>(msg,HttpStatus.OK);
				}
				else {
				   msg="Insufficient Balance";
				return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			    }
			}
			else
				msg="The Number that the money is to be sent has to be Registerd on the Application";
				return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	}	
	
}