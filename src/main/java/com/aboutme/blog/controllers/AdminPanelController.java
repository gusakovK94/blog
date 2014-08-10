package com.aboutme.blog.controllers;

import com.aboutme.blog.json.Auth;
import com.aboutme.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin")
public class AdminPanelController {

	private AdminService adminService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showFormPage() {
		return "admin/auth";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Auth authRequest(@RequestParam("login") String login,
								   	@RequestParam("password") String password) {

		Auth auth = new Auth();
		if (adminService.authenticate(login, password)) {
			auth.errorName = "authFailed";
			auth.errorMessage = "Неверный логин и/или пароль";
		} else {
			auth.redirectUrl = "1";
		}

		return auth;
	}

}
