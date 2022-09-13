package com.handykrafts.user;

import com.handykrafts.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/signup")
	public ResponseEntity<Response> userSignup(@RequestBody User user) {
		try {
	        Response signupResponse = us.userSignup(user);
	      if (signupResponse.isStatus()) {
	        return new ResponseEntity<Response>(signupResponse, HttpStatus.OK);
	      } else {
	        return new ResponseEntity<Response>(signupResponse, HttpStatus.BAD_REQUEST);
	      }

	    } catch (Exception e) {
	     Response signupResponse = null;
	      return new ResponseEntity<Response>(signupResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/signin")
	public ResponseEntity<Response> userSignin(@RequestBody User user){
		try {
	        Response signinResponse = us.userSignin(user);
	      if (signinResponse.isStatus()) {
	        return new ResponseEntity<Response>(signinResponse, HttpStatus.OK);
	      } else {
	        return new ResponseEntity<Response>(signinResponse, HttpStatus.BAD_REQUEST);
	      }

	    } catch (Exception e) {
	     Response signinResponse = null;
	      return new ResponseEntity<Response>(signinResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}

