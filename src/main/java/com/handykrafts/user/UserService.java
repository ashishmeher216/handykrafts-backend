package com.handykrafts.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public String userSignup(User user){
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
				return "Email already registered!";
			}
			dao.save(user);
			return "Registration success...";
		}catch(Exception e) {
			return "Registration failed!";
		}
	}
	
	public String userSignin(User user){
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
				return "Signin success...";
			}
			return "Invalid credentials!";
			
		}catch(Exception e) {
//			System.out.println(e);
			return "Something went wrong!";
		}
	}
}
