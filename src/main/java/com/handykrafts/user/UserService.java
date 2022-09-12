package com.handykrafts.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public String userSignup(User user){
		dao.save(user);
		System.out.println(user);
		return "Registration success...";
	}

}
