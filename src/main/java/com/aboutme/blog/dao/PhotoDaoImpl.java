package com.aboutme.blog.dao;

import com.aboutme.blog.dao.interfaces.PhotoDao;
import com.aboutme.blog.models.Photo;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class PhotoDaoImpl extends JdbcDaoSupport
								implements PhotoDao {


	@Override
	public void add(Photo photo) {

	}

	@Override
	public Photo find(int id) {
		return null;
	}

	@Override
	public void update(Photo photo) {

	}

	@Override
	public void delete(Photo photo) {

	}

	@Override
	public List<Photo> getPhotos() {
		return null;
	}
}
