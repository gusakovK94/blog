package com.aboutme.blog.models;

public class Photo {

	private int id;
	private String photoUrl;
	private int viewings;
	private int likes;

	public void setId(int id) {
		this.id = id;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public void setViewings(int viewings) {
		this.viewings = viewings;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public int getViewings() {
		return viewings;
	}

	public int getLikes() {
		return likes;
	}

}
