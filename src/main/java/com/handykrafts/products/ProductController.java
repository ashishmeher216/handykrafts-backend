package com.handykrafts.products;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//GET - Get all products
		@RequestMapping("/products")
		public List<Product> getAllProducts() {
			List<Product> list = productService.getAllProducts();
			
			return list;
		}
	
	//GET - Products For A Particular Category 
	@RequestMapping("/categories/{categoryId}/products")
	public List<Product> getAllProductsOfACategory(@PathVariable int categoryId) {
		List<Product> list = productService.getAllProductsOfACategory(categoryId);
		
		return list;
	}
	
	//GET - Product with a particular ID and category ID
	@RequestMapping("/categories/{categoryId}/products/{productId}")
	public List<Product> getProductByCategory(@PathVariable int productId) {
		return  productService.getProduct(productId);
	}
	
	//POST - Create Product For Category 
	@RequestMapping(method=RequestMethod.POST, value="/products/create")
	public void add(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	//PUT - Update Existing Products
	@RequestMapping(method=RequestMethod.PUT, value="/products/update")
	public void updateProduct(@RequestBody Product product) {
		productService.updateproduct(product);
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/categories/{categoryId}/products/{productId}")
//	public void deleteCategory(@PathVariable int id) {
//		productService.deleteCategory(id);
//	}

}
