package com.cybage.model;

public class SubCourse {
	  int subCourseId, subCourseDuration , courseId, videoSequence;
	  String subCourseName , subCourseDescription , videoUrl ;
	
	public SubCourse() {
		super();
	}
	
	public SubCourse(int subCourseId, int subCourseDuration, int courseId, String subCourseName, String subCourseDescription,
			String videoUrl, int videoSequence) {
		super();
		this.subCourseId = subCourseId;
		this.subCourseDuration = subCourseDuration;
		this.courseId = courseId;
		this.subCourseName = subCourseName;
		this.subCourseDescription = subCourseDescription;
		this.videoUrl = videoUrl;
		this.videoSequence = videoSequence;
	}
	public SubCourse( int subCourseDuration, int courseId, String subCourseName, String subCourseDescription,
			String videoUrl, int videoSequence) {
		super();
		
		this.subCourseDuration = subCourseDuration;
		this.courseId = courseId;
		this.subCourseName = subCourseName;
		this.subCourseDescription = subCourseDescription;
		this.videoUrl = videoUrl;
		this.videoSequence = videoSequence;
	}

	public int getSubCourseId() {
		return subCourseId;
	}

	public void setSubCourseId(int subCourseId) {
		this.subCourseId = subCourseId;
	}

	public int getSubCourseDuration() {
		return subCourseDuration;
	}

	public void setSubCourseDuration(int subCourseDuration) {
		this.subCourseDuration = subCourseDuration;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getVideoSequence() {
		return videoSequence;
	}

	public void setVideoSequence(int videoSequence) {
		this.videoSequence = videoSequence;
	}

	public String getSubCourseName() {
		return subCourseName;
	}

	public void setSubCourseName(String subCourseName) {
		this.subCourseName = subCourseName;
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

	@Override
	public String toString() {
		return "SubCourse [subCourseId=" + subCourseId + ", subCourseDuration=" + subCourseDuration + ", courseId="
				+ courseId + ", videoSequence=" + videoSequence + ", subCourseName=" + subCourseName
				+ ", subCourseDescription=" + subCourseDescription + ", videoUrl=" + videoUrl + "]";
	}

	
}
