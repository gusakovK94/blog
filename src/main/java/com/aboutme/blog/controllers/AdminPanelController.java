package com.aboutme.blog.controllers;

import com.aboutme.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public boolean authRequest(@RequestParam("login") String login,
								   	@RequestParam("password") String password, HttpSession httpSession) {

		if (adminService.authenticate(login, password)) {
			httpSession.setAttribute("admin", login);
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String authSuccess(HttpServletRequest request) {
		if (request.getSession(true).getAttribute("admin") == null) {
			return "redirect:/admin";
		}
		return "admin/index";
	}

}
