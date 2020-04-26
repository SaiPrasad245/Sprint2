package com.cg.sprint2.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint2.payment.dao.ShowWalletBalanceDAO;
import com.cg.sprint2.payment.dto.User;

@Service
public class ShowWalletBalanceService {
	
	@Autowired
	ShowWalletBalanceDAO sdao;

	public void setSdao(ShowWalletBalanceDAO sdao) {
		this.sdao = sdao;
	}
	
	// Show Wallet Balance
	
	public double showWalletBalanceOfUser(String mobileno)
	{
		User u =sdao.findById(mobileno).get();
		return u.getWalletbalance();
		
	}

	
	
	
	

}
