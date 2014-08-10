package com.aboutme.blog.dao.interfaces;

import com.aboutme.blog.models.Post;
import com.aboutme.blog.models.Tag;

import java.util.List;

public interface TagDao {

	public void add(Tag tag);

	public Tag find(int id);

	public void update(Tag tag);

	public void delete(Tag tag);

	public List<Post> getTags();

}
