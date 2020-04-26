package com.cg.sprint2.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint2.payment.dao.TransferAmountDAO;
import com.cg.sprint2.payment.dto.User;

@Service
public class TransferAmountService {

	@Autowired
	TransferAmountDAO tadao;

	public void setTadao(TransferAmountDAO tadao) {
		this.tadao = tadao;
	}

	public void transferAmountToAnotherWallet(String smobileno, String rmobileno, double amt) 
	{
		if(tadao.findById(smobileno)!=null)
		{
			Optional<User> u = tadao.findById(smobileno);
			if(tadao.findById(rmobileno)!=null);
			{
				if(amt<u.get().getWalletbalance())
				{
					System.out.println("Amount Transferred");
					tadao.deductFromSenderWallet(amt, smobileno);
					tadao.addToReciverWallet(amt, rmobileno);
				}
				else
				   System.out.println("Insufficient Balance");		
			}
		}}
		else
			System.out.println("Enter Correct Mobile No");		
	}
}