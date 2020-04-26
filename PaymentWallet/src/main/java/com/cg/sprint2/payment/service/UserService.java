package com.cg.sprint2.payment.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	// Login Of the User 
	public ResponseEntity<Optional<User>> checkUser( String mobileno, String password)
	{
		Optional<User> user =validateLogin(mobileno);
		Optional<User> empty = Optional.empty();
		if(user.isPresent()&&user.get().getPassword().equals(password))
		{
			return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
		}
		else
			if(user.get().getPassword().equals(password))
			{
				System.out.println("Invalid Password");
				return new ResponseEntity<Optional<User>>(empty,HttpStatus.NOT_FOUND);
			}
			else
			{
				System.out.println("Invalid User");
				return new ResponseEntity<Optional<User>>(empty,HttpStatus.NOT_FOUND);
			}
	 }
	// Adding User To the Payment Application
	public ResponseEntity<String> addUser(@RequestBody User user)
	  {
		  String smsg="Registration Sucessfully";
			 String umsg="Registration Failed";
			 if(createUser(user)!=null)
			 {
				 return new ResponseEntity<String>(smsg,HttpStatus.ACCEPTED);
			 }
			 else
			 {
				 return new ResponseEntity<String>(umsg,HttpStatus.BAD_REQUEST);
			 }
	  }
}
