package com.handykrafts.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity userSignup(User user){
		try {
			Boolean b = false;
			List<User> allUsers = (List<User>) dao.findAll();
			for(User u : allUsers) {
				if(u.getEmail().equals(user.getEmail())){
					b=true;
					break;
				}
			}
			if(b) {
				return new ResponseEntity<>("Email already registered!", HttpStatus.BAD_REQUEST);
			}
			dao.save(user);
			return new ResponseEntity<>("Registration success...", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity userSignin(User user){
		System.out.println(user);
		try {
			Boolean b = false;
			List<User> allUsers = (List<User>) dao.findAll();
			for(User u : allUsers) {
				if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())){
					b=true;
					break;
				}
			}
			if(b) {
				return new ResponseEntity<>("Signin success...", HttpStatus.OK);
			}
			return new ResponseEntity<>("Invalid credentials!", HttpStatus.BAD_REQUEST);			
		}catch(Exception e) {
			return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
