package com.cg.sprint2.payment.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.sprint2.payment.dto.TransactionHistory;

public interface TransactionHistoryDAO  extends JpaRepository<TransactionHistory, Integer>{
	


	@Query("select d from TransactionHistory d where (d.dateoftrans between :fromdate and :todate) AND (d.smobileno=:smobileno or d.rmobileno=:rmobileno)")
	public List<TransactionHistory> showAllTransactionsBetweenDates(Date fromdate, Date todate,String smobileno,String rmobileno);

	@Query("select d from TransactionHistory d where d.smobileno=:smobileno")
	public List<TransactionHistory> showSentTransactions(String smobileno);
	
	@Query("select t from TransactionHistory t where t.rmobileno=:rmobileno")
	public List<TransactionHistory> showRecievedTransactions(String rmobileno);
}
