package com.handykrafts.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class CategoryController {

	@Autowired
	private CategoryService category;
	
	@RequestMapping("/categories")
	public List<Category> getAllCategories() {
		return category.getAllCategories();
	}
	
	@RequestMapping("/categories/{id}")
	public List<Category> getCategory(@PathVariable int id) {
		return  category.getCategories(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories/create")
	public void add(@RequestBody Category cat) {
		category.addCategory(cat);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/categories/{id}")
	public void updateCategory(@RequestBody Category cat, @PathVariable int id) {
		category.updateCategory(id, cat);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		category.deleteCategory(id);
	}

}
