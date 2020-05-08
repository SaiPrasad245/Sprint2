package com.cg.sprint2.payment.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint2.payment.dao.TransactionHistoryDAO;
import com.cg.sprint2.payment.dto.TransactionHistory;

@Service
public class TransactionHistoryService {
	
	@Autowired
	TransactionHistoryDAO thdao;
	
	public void setThdao(TransactionHistoryDAO thdao) {
		this.thdao = thdao;
	}
	
	// Transaction History By Date to Date
	
      public List<TransactionHistory> showAllTransactionsBetweenDates(Date fromdate,Date todate, String mobileno,String rmobileno)
      {
    	  return thdao.showAllTransactionsBetweenDates(fromdate,todate,mobileno,mobileno);
      }
	
   // Sent Transaction History 
      public List<TransactionHistory> showSentTransaction( String mobileno)
      {
    	  return thdao.showSentTransactions(mobileno);
      }
      
     
   // s Transaction History 
      public List<TransactionHistory> showRecievedTransaction( String mobileno)
      {
    	  return thdao.showRecievedTransactions(mobileno);
      }
	
	

}
