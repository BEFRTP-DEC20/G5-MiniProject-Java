package com.cybage.model;
public class EnrolledCourse {
	int enrollmentId, coursePrice, currentVideo, courseId, userId; 
	String purchaseDate, certificateUrl;
	boolean  courseComplete;
	
	
	public EnrolledCourse(int courseId, int userId, int coursePrice, String PurchaseDate)
	{
		this.courseId=courseId;
		this.userId=userId;
		this.coursePrice=coursePrice;
		this.purchaseDate = PurchaseDate;
		this.enrollmentId =(int) Math.random()*10000;
		this.currentVideo=1;
		this.certificateUrl=null;
		this.courseComplete=false;
	}
	
	
	
	public int getCoursePrice() {
		return coursePrice;
	}



	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}



	public int getCurrentVideo() {
		return currentVideo;
	}



	public void setCurrentVideo(int currentVideo) {
		this.currentVideo = currentVideo;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getCertificateUrl() {
		return certificateUrl;
	}



	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}



	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public boolean isCourseComplete() {
		return courseComplete;
	}
	public void setCourseComplete(boolean courseComplete) {
		this.courseComplete = courseComplete;
	}
	
	
}
