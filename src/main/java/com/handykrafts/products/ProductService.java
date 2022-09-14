package com.handykrafts.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		dao.findAll()
		.forEach(product -> {
			products.add(product);
		});
		return products;
	}
	
	public List<Product> getAllProductsOfACategory(int categoryId){
		List<Product> products = new ArrayList<>();
		dao.findAll()
		.forEach(product -> {
			if(product.getCategoryId() == categoryId)
			products.add(product);
		});
		return products;
	}
	
	
	public List<Product> getProduct(int productId) {
	  List<Product> list = new ArrayList<Product>(); 
	  
	  dao.findAll().forEach(product ->{
		  if(product.getProductId() == productId)
		  {
			  list.add(product);
		  }
	  });
		
	  return list;
	}

	public void addProduct(Product p) {
		System.out.println(p);
		dao.save(p);	
	}

	public void updateproduct(Product p) {
		dao.save(p);
	}

//	public void deleteCategory(int id) {
//		dao.deleteById(id);
//	}
	
}