package com.cybage.model;

public class Category {
	private int categoryId;
	private String categoryName, imageUrl;
	
	public Category() {
		super();
	}
	public Category(int categoryId, String categoryName, String imageUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
	}
	public Category(String categoryName, String imageUrl) {
		super();
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", imageUrl=" + imageUrl + "]";
	}
  
}
