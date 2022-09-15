package com.handykrafts.cart;

import org.springframework.data.repository.CrudRepository;

public interface CartDao extends CrudRepository<Cart, Integer> {
	
}
