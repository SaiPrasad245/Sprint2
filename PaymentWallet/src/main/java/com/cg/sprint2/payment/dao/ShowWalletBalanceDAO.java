package com.cg.sprint2.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint2.payment.dto.User;

public interface ShowWalletBalanceDAO extends JpaRepository<User, String>{
	

}
