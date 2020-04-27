package com.cg.sprint2.payment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.dto.TransactionHistory;
import com.cg.sprint2.payment.service.TransactionHistoryService;

@RestController
public class TransactionHistoryController {
	
	@Autowired
	TransactionHistoryService thservice;
	public void setThservice(TransactionHistoryService thservice) {
		this.thservice = thservice;
	}
	// All Transactions Between the Dates
	@GetMapping(value="/showAllTransactions/{fromdate}/{todate}/{smobileno}",produces="application/json")
	public List<TransactionHistory> showAllTransactionBetweenDates(@PathVariable String fromdate,@PathVariable String todate,@PathVariable String smobileno) throws ParseException
	{
	
		Date fdate = new SimpleDateFormat("dd-MMM-yy").parse(fromdate);
		Date tdate = new SimpleDateFormat("dd-MMM-yy").parse(todate);
		List<TransactionHistory> transactions=thservice.showAllTransactionsBetweenDates(fdate, tdate, smobileno,smobileno);
		return transactions;
	}
	// Sent Transactions
	@GetMapping(value="/showSentTransactions/{smobileno}",produces="application/json")
	public List<TransactionHistory> showSentTransactions(@PathVariable String smobileno)
	{
		List<TransactionHistory> transactions=thservice.showSentTransaction(smobileno);
		return transactions;
	}
	// Received Transactions
		@GetMapping(value="/showRecievedTransactions/{rmobileno}",produces="application/json")
		public List<TransactionHistory> showRecievedTransactions(@PathVariable String rmobileno)
		{
			List<TransactionHistory> transactions=thservice.showRecievedTransaction(rmobileno);
			return transactions;
		}
}
