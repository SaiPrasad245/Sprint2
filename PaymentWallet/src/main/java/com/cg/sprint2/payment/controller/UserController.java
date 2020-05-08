package com.cg.sprint2.payment.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint2.payment.dto.User;
import com.cg.sprint2.payment.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	
	UserService uservice;
	public void setUservice(UserService uservice) {
		this.uservice = uservice;}
	
	
	   // Validating User Credentials
	@GetMapping(value="/login/{mobileno}/{password}",produces="application/json")
	public ResponseEntity<Optional<User>>  checkUser(@PathVariable String mobileno,@PathVariable String password)
	{
	    return uservice.checkUser(mobileno, password);
	}

	
	   // Creating a new User
	@PostMapping(value = "/signup", consumes = "application/json")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		String message="{\"status\":\"success\"}";
		   if(uservice.createUser(user)==null) {
			   message="{\"status\":\"error\"}";
			   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		   }
		   return new ResponseEntity<String>(message,HttpStatus.OK);
	}
		
		
	

	

}
