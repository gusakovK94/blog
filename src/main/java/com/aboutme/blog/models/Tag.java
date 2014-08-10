package com.aboutme.blog.models;

public class Tag {

	private int id;
	private String tagName;
	private int popularity;

	public void setId(int id) {
		this.id = id;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public int getPopularity() {
		return popularity;
	}

}
