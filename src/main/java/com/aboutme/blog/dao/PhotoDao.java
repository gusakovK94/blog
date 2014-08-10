package com.aboutme.blog.dao;

import com.aboutme.blog.models.Photo;

import java.util.List;

public interface PhotoDao {

	public void add(Photo photo);

	public Photo find(int id);

	public void update(Photo photo);

	public void delete(Photo photo);

	public List<Photo> getPhotos();

}
