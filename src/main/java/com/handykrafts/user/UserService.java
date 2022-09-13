package com.handykrafts.user;

import java.util.List;

import com.handykrafts.response.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	
	public Response userSignup(User user){
		Response Response = new Response();
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
				Response.setStatus(false);
				Response.setMessage("Email already registered!");
				return Response;
			}
			
			//hash the password using bcrypt
			String salt = BCrypt.gensalt();
		    String hashedPwd = BCrypt.hashpw(user.getPassword(), salt);
		    user.setPassword(hashedPwd);
		    user.setSalt(salt);
			dao.save(user);
			Response.setStatus(true);
			Response.setMessage("Registration successful!");
			return Response;
		}catch(Exception e) {
			Response.setStatus(false);
			Response.setMessage("Registration failed!");
			return Response;
		}
	}
	
	public Response userSignin(User user){
		Response Response = new Response();
		JSONObject obj = new JSONObject();
		try {
			Boolean b = false;
			List<User> allUsers = (List<User>) dao.findAll();
			
			for(User u : allUsers) {
				if(u.getEmail().equals(user.getEmail())){
					String salt = u.getSalt();
			        String hashedPwd = BCrypt.hashpw(user.getPassword(), salt);
			        if(hashedPwd.equals(u.getPassword())) {
			        	b=true;
						obj.put("fname", u.getFname());
						obj.put("lname", u.getLname());
						obj.put("email", u.getEmail());
						break;
			        }
				}
			}
			if(b) {
				Response.setStatus(true);
				Response.setMessage("Signin successful!");
				Response.setPayload(obj);
				return Response;
			}
			
			Response.setMessage("Invalid credentials!");
			return Response;
			
		}catch(Exception e) {
			
			Response.setStatus(false);
		    Response.setMessage("Something went wrong!");
		    return Response;
		}
	}
}
