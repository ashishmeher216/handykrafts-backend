package com.handykrafts.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/signup")
	public ResponseEntity<User> userSignup(@RequestBody User user) {
		return us.userSignup(user);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<User> getTickets(@RequestBody User user){
		return us.userSignin(user);
	}
}

