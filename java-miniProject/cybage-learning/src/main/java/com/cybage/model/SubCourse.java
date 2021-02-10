package com.cybage.model;



public class SubCourse {
	private int subCourseId;
	String subCourseName;
	int subCourseDuration;
	String subCourseDescription;
	String videoUrl;
	int videoSequence;
	int courseId;

	public SubCourse() {
		super();
	}

	public SubCourse(int subCourseId, String subCourseName, int subCourseDuration, String subCourseDescription,
			String videoUrl, int videoSequence, int courseId) {
		super();
		this.subCourseId = subCourseId;
		this.subCourseName = subCourseName;
		this.subCourseDuration = subCourseDuration;
		this.subCourseDescription = subCourseDescription;
		this.videoUrl = videoUrl;
		this.videoSequence = videoSequence;
		this.courseId = courseId;
	}

	public int getSubCourseId() {
		return subCourseId;
	}

	public void setSubCourseId(int subCourseId) {
		this.subCourseId = subCourseId;
	}

	public String getSubCourseName() {
		return subCourseName;
	}

	public void setSubCourseName(String subCourseName) {
		this.subCourseName = subCourseName;
	}

	public int getSubCourseDuration() {
		return subCourseDuration;
	}

	public void setSubCourseDuration(int subCourseDuration) {
		this.subCourseDuration = subCourseDuration;
	}

	public String getSubCourseDescription() {
		return subCourseDescription;
	}

	public void setSubCourseDescription(String subCourseDescription) {
		this.subCourseDescription = subCourseDescription;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getVideoSequence() {
		return videoSequence;
	}

	public void setVideoSequence(int videoSequence) {
		this.videoSequence = videoSequence;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "SubCourse [subCourseId=" + subCourseId + ", subCourseName=" + subCourseName + ", subCourseDuration="
				+ subCourseDuration + ", subCourseDescription=" + subCourseDescription + ", videoUrl=" + videoUrl
				+ ", videoSequence=" + videoSequence + ", courseId=" + courseId + "]";
	}

}
