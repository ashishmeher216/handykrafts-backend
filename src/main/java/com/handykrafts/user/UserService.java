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
			        	//set the loggedIn flag to true for that user in database and send his details
						u.setLoggedIn(true);
						dao.save(u);
						
						b=true;
						obj.put("fname", u.getFname());
						obj.put("lname", u.getLname());
						obj.put("email", u.getEmail());
						obj.put("loggedIn", u.getLoggedIn());
						
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
			Response.setStatus(false);
			Response.setMessage("Invalid credentials!");
			return Response;
			
		}catch(Exception e) {
			
			Response.setStatus(false);
		    Response.setMessage("Something went wrong!");
		    return Response;
		}
	}
	
	
	public Response userSignout(User user){
		Response Response = new Response();
		try {
			Boolean b = false;
			List<User> allUsers = (List<User>) dao.findAll();
			
			for(User u : allUsers) {
				if(u.getEmail().equals(user.getEmail())){
			        	
		        	//set the loggedIn flag to false for that user in database and send his details
					u.setLoggedIn(false);
					dao.save(u);
					
					b=true;
					
					break;
				}
			}
			if(b) {
				Response.setStatus(true);
				Response.setMessage("Signout successful!");
				return Response;
			}
			
			Response.setStatus(false);
			Response.setMessage("You must be logged in!");
			return Response;
			
		}catch(Exception e) {
			Response.setStatus(false);
		    Response.setMessage("Something went wrong!");
		    return Response;
		}
	}
}
