package com.springboot.expensetrackerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.expensetrackerapi.exception.ETBadRequestException;
import com.springboot.expensetrackerapi.exception.ETResourceNotFoundException;
import com.springboot.expensetrackerapi.model.Category;
import com.springboot.expensetrackerapi.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> fetchCategories(Integer userId) {
		return categoryRepository.findAll(userId);
	}

	@Override
	public Category fetchCategoryById(Integer userId, Integer categoryId) throws ETResourceNotFoundException {
		return categoryRepository.findById(userId, categoryId);
	}

	@Override
	public Category addCategory(Integer userId, String title, String description) throws ETBadRequestException {
		int categoryId = categoryRepository.create(userId, title, description);
		return categoryRepository.findById(userId, categoryId);
	}

	@Override
	public void updateCategory(Integer userId, Integer categoryId, Category category) throws ETBadRequestException {
		categoryRepository.update(userId, categoryId, category);
	}

	@Override
	public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws ETResourceNotFoundException {
		this.fetchCategoryById(userId, categoryId);
		categoryRepository.removeById(userId, categoryId);
		
	}
	
}
