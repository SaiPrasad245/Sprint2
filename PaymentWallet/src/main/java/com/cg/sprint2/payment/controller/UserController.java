package com.cg.sprint2.payment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint2.payment.dto.User;
import com.cg.sprint2.payment.service.UserService;

@RestController
public class UserController {
	@Autowired
	
	UserService uservice;
	public void setUservice(UserService uservice) {
		this.uservice = uservice;}
	
	
	// Validating User Credentials
	@GetMapping(value="/login/{mobileno}/{password}",produces="application/json")
		public ResponseEntity<Optional<User>> checkUser(@PathVariable String mobileno,@PathVariable String password)
		{
			Optional<User> user = uservice.validateLogin(mobileno);
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
				}}
	
	// Creating a new User
	  @PostMapping(value="/signup",consumes="application/json")
	  public ResponseEntity<String> addUser(@RequestBody User user)
	  {
		  String smsg="Registration Sucessfully";
			 String umsg="Registration Failed";
			 if(uservice.createUser(user)!=null)
			 {
				 return new ResponseEntity<String>(smsg,HttpStatus.ACCEPTED);
			 }
			 else
			 {
				 return new ResponseEntity<String>(umsg,HttpStatus.BAD_REQUEST);
			 }
	  }
		
		
	

	

}
