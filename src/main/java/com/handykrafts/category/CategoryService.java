package com.handykrafts.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

	@Autowired
	private CategoryDao dao;
	
	public List<Category> getAllCategories(){
		List<Category> categories=new ArrayList<>();
		dao.findAll()
		.forEach(categories::add);
		return categories;
	}
	
	//Showing Error
	public List<Category> getCategories(int id) {
		Optional <Category> opt=dao.findById(id);
		return opt
	            .map(Collections::singletonList)
	            .orElseGet(Collections::emptyList);
	}

	public void addCategory(Category category) {
		dao.save(category);
		
	}

	public void updateCategory(int id, Category category) {
		dao.save(category);
	}

	public void deleteCategory(int id) {
		dao.deleteById(id);
	}
	
}