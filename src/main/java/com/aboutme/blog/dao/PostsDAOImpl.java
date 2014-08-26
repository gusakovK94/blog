package com.aboutme.blog.dao;

import com.aboutme.blog.dao.interfaces.PostsDao;
import com.aboutme.blog.models.Post;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class PostsDAOImpl extends JdbcDaoSupport
							implements PostsDao {

	private static final String SQL_INSERT_POST = "INSERT INTO posts (topic, image, author, content, date) " +
			"VALUES (?, ?, ?, ?, ?)";
	@Override
	public void add(Post post) {
		getJdbcTemplate().update(SQL_INSERT_POST,
								post.getTopic(),
								post.getImage(),
								post.getAuthor(),
								post.getContent(),
								post.getDate());
	}

	@Override
	public Post find(int id) {
		return null;
	}

	@Override
	public void update(Post post) {

	}

	@Override
	public void delete(Post post) {

	}

	@Override
	public List<Post> getPosts() {
		return null;
	}
}
