package com.cybage.model;

public class CurrentVideo {
	private String username;
	private int courseId;
	private int currentVideoInDb;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCurrentVideoInDb() {
		return currentVideoInDb;
	}

	public void setCurrentVideoInDb(int currentVideoInDb) {
		this.currentVideoInDb = currentVideoInDb;
	}

	public CurrentVideo(String username, int courseId, int currentVideoInDb) {
		super();
		this.username = username;
		this.courseId = courseId;
		this.currentVideoInDb = currentVideoInDb;
	}

}