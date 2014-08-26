package com.aboutme.blog.controllers;

import com.aboutme.blog.models.Post;
import com.aboutme.blog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin/posts")
public class PostsController {

	private PostsService postsService;

	@Autowired
	public void setPostsService(PostsService postsService) {
		this.postsService = postsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showMainPostPage(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("admin") == null) {
			return "admin/auth";
		} else {
			model.addAttribute("post", new Post());
			return "admin/posts";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String savePost(@ModelAttribute Post post, @RequestParam(value = "tag", required = false) String tags,
						   @RequestParam(value = "photo",required = false) MultipartFile photo) {

		postsService.savePost(post, tags, photo);
		return "redirect:/admin/posts";
	}

}
