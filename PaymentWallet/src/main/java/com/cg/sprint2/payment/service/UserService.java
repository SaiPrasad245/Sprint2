package com.cg.sprint2.payment.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.sprint2.payment.dao.UserDAO;
import com.cg.sprint2.payment.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDAO udao;

	public void setUdao(UserDAO udao)
	{
		this.udao = udao;
	}
	// Verification of the user
	@Transactional (readOnly=true)
   public Optional<User> validateLogin(String mobileno)
   {
	   return udao.findById(mobileno); 
   }
	
	// Registration of new user
	public User createUser(User user)
	{
		return udao.save(user);
	}
}
