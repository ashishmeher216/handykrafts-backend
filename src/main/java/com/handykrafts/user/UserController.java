package com.handykrafts.user;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello";
//	}
	
	@PostMapping("/signup")
	public void userSignup(@RequestBody User user) {
		System.out.println("Hello user...");
//		us.userSignup(user);

	}
	
//	@PostMapping("/signin")
//	public String getTickets(){
//		return (List<Ticket>) dao.findAll();
//	}
}

