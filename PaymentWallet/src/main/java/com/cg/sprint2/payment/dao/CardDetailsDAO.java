package com.cg.sprint2.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint2.payment.dto.CardDetails;

@Repository
public interface CardDetailsDAO  extends JpaRepository<CardDetails,String>
{

	 @Transactional
	 @Modifying
	 @Query("update CardDetails cd set  cd.cardbalance=cd.cardbalance+:amount where (cd.upiid=:upiid)" )
	public void addToReciverUpi(double amount, String upiid);
	
	 @Transactional
	 @Modifying
	 @Query("update CardDetails cd set  cd.cardbalance=cd.cardbalance-:amount where (cd.upiid=:upiid)" )
	public void deductFromSenderUpi(double amount, String upiid);
	
}

