package com.aboutme.blog.controllers;

import com.aboutme.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminPanelController {

	private AdminService adminService;

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean authRequest(@RequestParam("login") String login,
								   	@RequestParam("password") String password, HttpSession httpSession) {

		if (adminService.authenticate(login, password)) {
			httpSession.setAttribute("admin", login);
			return true;
		}
		return false;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAdminIndexOrFormPage(HttpSession httpSession) {
		if (httpSession.getAttribute("admin") == null) {
			return "admin/auth";
		} else {
			return "admin/index";
		}
	}

}
