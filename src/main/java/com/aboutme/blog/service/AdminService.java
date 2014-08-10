package com.aboutme.blog.service;

import com.aboutme.blog.dao.interfaces.AdminUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

	private AdminUserDAO adminDAO;

	public AdminService() {

	}

	@Autowired
	public void setAdminDAO(AdminUserDAO adminDAO) {
		this.adminDAO = adminDAO;
	}



	public boolean authenticate(String login, String password) {
		if (adminDAO.find(login, password).isEmpty()) {
			return false;
		}
		return true;
	}

}
