package com.aboutme.blog.dao.interfaces;

import com.aboutme.blog.models.Admin;

import java.util.List;

public interface AdminUserDAO {

	public List<Admin> find(String login, String password);


}
