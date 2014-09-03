package com.aboutme.blog.models;

import java.util.Date;

public class Post {

	private int id;
	private String topic;
	private String author;
	/**/private String tag;
	private String image;
	private String content;
	private Date date;
	private String description;

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getTopic() {
		return topic;
	}

	public String getAuthor() {
		return author;
	}

	public String getTag() {
		return tag;
	}

	public String getImage() {
		return image;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

}
