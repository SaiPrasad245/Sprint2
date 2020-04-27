package com.cg.sprint2.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.cg.sprint2.payment.dto.User;

public interface TransferAmountDAO  extends JpaRepository<User,String>{
	@Transactional
	@Modifying
	@Query("update User u  set  u.walletbalance=u.walletbalance+:amount where u.mobileno=:mobileno")
	public void addToReciverWallet(double amount, String mobileno);

	@Transactional
	@Modifying
	@Query("update User u  set  u.walletbalance=u.walletbalance-:amount where u.mobileno=:mobileno")
	public void deductFromSenderWallet(double amount, String mobileno);
	
}
