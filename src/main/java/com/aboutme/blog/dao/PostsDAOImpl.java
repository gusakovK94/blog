package com.aboutme.blog.dao;

import com.aboutme.blog.dao.interfaces.PostsDao;
import com.aboutme.blog.models.Post;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostsDAOImpl extends JdbcDaoSupport
							implements PostsDao {

	private static final String SQL_INSERT_POST = "INSERT INTO posts (topic, image, author, content, date, description) " +
			"VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_POST = "UPDATE posts SET topic = ?, image = ?, author = ?, content = ?, date = ?, description = ?" +
			"WHERE id = ?";
	private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE id = ?";

	@Override
	public void add(Post post) {
		getJdbcTemplate().update(SQL_INSERT_POST,
								post.getTopic(),
								post.getImage(),
								post.getAuthor(),
								post.getContent(),
								post.getDate(),
								post.getDescription());
	}

	@Override
	public Post find(int id) {
		return null;
	}

	@Override
	public void update(Post post) {
		getJdbcTemplate().update(SQL_UPDATE_POST,
								post.getTopic(),
								post.getImage(),
								post.getAuthor(),
								post.getContent(),
								post.getDate(),
								post.getDescription(),
								post.getId());
	}

	@Override
	public void delete(int post_id) {
		getJdbcTemplate().update(SQL_DELETE_POST,
								post_id);
	}

	@Override
	public List<Post> getPosts(int offset) {
		List<Post> posts = getJdbcTemplate().query(
				"SELECT * FROM posts ORDER BY id DESC LIMIT 7 OFFSET " + offset ,
				new RowMapper<Post>() {
					public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
						Post post = new Post();
						post.setId(rs.getInt("id"));
						post.setTopic(rs.getString("topic"));
						post.setAuthor(rs.getString("author"));
						post.setImage(rs.getString("image"));
						post.setContent(rs.getString("content"));
						post.setDate(rs.getDate("date"));
						post.setDescription(rs.getString("description"));
						return post;
					}
				});

		return posts;
	}

	public List<Post> getAllPosts() {
		List<Post> posts = getJdbcTemplate().query(
				"SELECT * FROM posts",
				new RowMapper<Post>() {
					public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
						Post post = new Post();
						post.setId(rs.getInt("id"));
						post.setTopic(rs.getString("topic"));
						post.setAuthor(rs.getString("author"));
						post.setImage(rs.getString("image"));
						post.setContent(rs.getString("content"));
						post.setDate(rs.getDate("date"));
						post.setDescription(rs.getString("description"));
						return post;
					}
				});

		return posts;
	}
}
