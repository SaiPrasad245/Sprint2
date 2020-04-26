package com.cg.sprint2.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<String> transferAmountToAnotherWallet(String smobileno, String rmobileno, double amt) 
	{
		String msg="";
			Optional<User> u = tadao.findById(smobileno);
			if(tadao.findById(rmobileno).isPresent());
			{
				if(amt<u.get().getWalletbalance())
				{
					msg="Amount Transferred";
					tadao.deductFromSenderWallet(amt, smobileno);
					tadao.addToReciverWallet(amt, rmobileno);
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