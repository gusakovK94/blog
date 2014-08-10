package com.aboutme.blog.models;

import java.util.Date;

public class Post {

	private int id;
	private String image;
	private int likes;
	private Date date;
	private int viewings;
	private String content;

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setViewings(int viewings) {
		this.viewings = viewings;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public int getLikes() {
		return likes;
	}

	public Date getDate() {
		return date;
	}

	public int getViewings() {
		return viewings;
	}

	public String getContent() {
		return content;
	}

}
