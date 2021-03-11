package com.springboot.expensetrackerapi.repository;

import java.util.List;

import com.springboot.expensetrackerapi.exception.ETBadRequestException;
import com.springboot.expensetrackerapi.exception.ETResourceNotFoundException;
import com.springboot.expensetrackerapi.model.Category;

public interface CategoryRepository {
	
	List<Category> findAll(Integer userId) throws ETResourceNotFoundException;
	
	Category findById(Integer userId, Integer categoryId) throws ETResourceNotFoundException;
	
	Integer create(Integer userId, String title, String description) throws ETBadRequestException;
	
	void update(Integer userId, Integer categoryId, Category category) throws ETBadRequestException;
	
	void removeById(Integer userId, Integer categoryId);
	
}
