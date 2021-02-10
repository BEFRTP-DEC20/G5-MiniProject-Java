package com.cybage.model;

public class Course {
	String courseName, courseAuthor, courseDescription, imageUrl;
	int courseId, categoryId, coursePrice, totalSubCourse, courseDuration;
	
	public Course() {
		super();
	}
	
	public Course( int courseId, String courseName, String courseAuthor, String courseDescription, String imageUrl,
			int courseDuration, int coursePrice, int totalSubCourse) {
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
			int courseDuration, int coursePrice,int totalSubCourse, int categoryId) {
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

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((courseAuthor == null) ? 0 : courseAuthor.hashCode());
		result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
		result = prime * result + courseDuration;
		result = prime * result + courseId;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + coursePrice;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + totalSubCourse;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (categoryId != other.categoryId)
			return false;
		if (courseAuthor == null) {
			if (other.courseAuthor != null)
				return false;
		} else if (!courseAuthor.equals(other.courseAuthor))
			return false;
		if (courseDescription == null) {
			if (other.courseDescription != null)
				return false;
		} else if (!courseDescription.equals(other.courseDescription))
			return false;
		if (courseDuration != other.courseDuration)
			return false;
		if (courseId != other.courseId)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (coursePrice != other.coursePrice)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (totalSubCourse != other.totalSubCourse)
			return false;
		return true;
	}
	
	

	
	
	
	
	
}
