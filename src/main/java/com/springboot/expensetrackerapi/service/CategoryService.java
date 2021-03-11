package com.springboot.expensetrackerapi.service;

import java.util.List;

import com.springboot.expensetrackerapi.exception.ETBadRequestException;
import com.springboot.expensetrackerapi.exception.ETResourceNotFoundException;
import com.springboot.expensetrackerapi.model.Category;

public interface CategoryService {
	
	List<Category> fetchCategories(Integer userId);
	
	Category fetchCategoryById(Integer userId, Integer categoryId) throws ETResourceNotFoundException;
	
	Category addCategory(Integer userId, String title, String description) throws ETBadRequestException;
	
	void updateCategory(Integer userId, Integer categoryId, Category category) throws ETBadRequestException;

	void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws ETResourceNotFoundException;
	
}
