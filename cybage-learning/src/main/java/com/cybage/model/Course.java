package com.cybage.model;

public class Course {
	String courseName, courseAuthor, courseDescription, imageUrl, courseDuration;
	int courseId, categoryId, coursePrice, totalSubCourse;
	
	public Course() {
		super();
	}
	
	public Course(String courseName, String courseAuthor, String courseDescription, String imageUrl, int courseId,
			String courseDuration, int coursePrice, int totalSubCourse) {
		super();
		this.courseName = courseName;
		this.courseAuthor = courseAuthor;
		this.courseDescription = courseDescription;
		this.imageUrl = imageUrl;
		this.courseId = courseId;
		this.courseDuration = courseDuration;
		this.coursePrice = coursePrice;
		this.totalSubCourse = totalSubCourse;
	}
	
	public Course(String courseName, String courseAuthor, String courseDescription, String imageUrl, 
			 String courseDuration, int coursePrice,int totalSubCourse, int categoryId) {
		super();
		this.courseName = courseName;
		this.courseAuthor = courseAuthor;
		this.courseDescription = courseDescription;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
		this.courseDuration = courseDuration;
		this.coursePrice = coursePrice;
		this.totalSubCourse = totalSubCourse;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseAuthor() {
		return courseAuthor;
	}

	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public int getTotalSubCourse() {
		return totalSubCourse;
	}

	public void setTotalSubCourse(int totalSubCourse) {
		this.totalSubCourse = totalSubCourse;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseAuthor=" + courseAuthor + ", courseDescription="
				+ courseDescription + ", imageUrl=" + imageUrl + ", courseDuration=" + courseDuration + ", courseId="
				+ courseId + ", categoryId=" + categoryId + ", coursePrice=" + coursePrice + ", totalSubCourse="
				+ totalSubCourse + "]";
	}

	
	
	
	
	
}
