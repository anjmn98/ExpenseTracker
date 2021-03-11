package com.springboot.expensetrackerapi.model;

public class Category {
	private Integer categoryId;
	private Integer userId;
	private String title;
	private String description;
	private Double totalExpense;
	
	public Category(Integer categoryId, Integer userId, String title, String description, Double totalExpense) {
		super();
		this.categoryId = categoryId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.totalExpense = totalExpense;
	}
	
	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the totalExpense
	 */
	public Double getTotalExpense() {
		return totalExpense;
	}
	/**
	 * @param totalExpense the totalExpense to set
	 */
	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}
	
	
	
	
}
