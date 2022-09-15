package com.handykrafts.cart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class CartService {
	@Autowired
	private CartDao cartDao;

	
	public void addToCart(@RequestBody ArrayList<Cart> cart) {
		for (Cart cI : cart) {
			System.out.println("The cI value is -> "+cI);
			cartDao.save(cI);
		}
	}
}
