package com.cg.sprint2.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint2.payment.dto.CardDetails;

@Repository
public interface AddMoneyToWalletDAO extends JpaRepository<CardDetails, String> {

	@Transactional
	@Modifying
	@Query("update User u  set  u.walletbalance=u.walletbalance+:amount where u.mobileno=:mobileno")
	public void addToWallet(double amount, String mobileno);

	 @Transactional
	 @Modifying
	 @Query("update CardDetails cd set  cd.cardbalance=cd.cardbalance-:amount where cd.cardno=:cardno")
	 public void deductBalance(double amount,long cardno);

}
