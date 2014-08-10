package com.aboutme.blog.dao.interfaces;

import com.aboutme.blog.models.Post;

import java.util.List;

public interface PostsDao {

	public void add(Post post);

	public Post find(int id);

	public void update(Post post);

	public void delete(Post post);

	public List<Post> getPosts();

}
