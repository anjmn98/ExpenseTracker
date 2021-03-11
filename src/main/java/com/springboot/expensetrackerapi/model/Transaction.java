package com.springboot.expensetrackerapi.model;

public class Transaction {
	
	private Integer transactionId;
	private Integer categoryId;
	private Integer userId;
	private Double Amount;
	private String note;
	private Long transactionDate;
	
	public Transaction(Integer transactionId, Integer categoryId, Integer userId, Double amount, String note,
			Long transactionDate) {
		super();
		this.transactionId = transactionId;
		this.categoryId = categoryId;
		this.userId = userId;
		Amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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
	 * @return the amount
	 */
	public Double getAmount() {
		return Amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		Amount = amount;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the transactionDate
	 */
	public Long getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Long transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	
}
