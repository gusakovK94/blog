package com.aboutme.blog.controllers;

import com.aboutme.blog.models.Post;
import com.aboutme.blog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class PostsController {

	private PostsService postsService;
	private static final double POSTS_ON_PAGE = 7;
	private double postsCount;

	@Autowired
	public void setPostsService(PostsService postsService) {
		this.postsService = postsService;
		postsCount = postsService.getAllPosts().size();
	}

	@RequestMapping(value = "admin/posts", method = RequestMethod.GET)
	public String showMainPostPage(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("admin") == null) {
			return "admin/auth";
		} else {
			model.addAttribute("post", new Post());
			model.addAttribute("posts", postsService.getPosts(0));
			model.addAttribute("pagsize", Math.ceil(postsCount/POSTS_ON_PAGE));
			return "admin/posts";
		}
	}

	@RequestMapping(value = "/admin/posts/pages/{page}", method = RequestMethod.GET)
	public String showCurrentPostPage(Model model, HttpSession httpSession, @PathVariable int page) {
		if (httpSession.getAttribute("admin") == null) {
			return "admin/auth";
		} else {
			model.addAttribute("post", new Post());
			model.addAttribute("posts", postsService.getPosts((page - 1)*7));
			model.addAttribute("pagsize", Math.ceil(postsCount/POSTS_ON_PAGE));
			return "admin/posts";
		}
	}

	@RequestMapping(value = "/admin/posts", method = RequestMethod.POST)
	public String savePost(@ModelAttribute Post post, @RequestParam(value = "tag", required = false) String tags,
						   @RequestParam(value = "photo",required = false) MultipartFile photo) {

		postsService.savePost(post, tags, photo);
		postsCount++;
		return "redirect:/admin/posts";
	}

	@RequestMapping(value = "/admin/post/edit/{post_id}", method = RequestMethod.POST)
	public String editPost(@PathVariable int post_id, @RequestParam("topic") String topic,
						   	@RequestParam("author") String author, @RequestParam("description") String description,
							@RequestParam("content") String content, @RequestParam("imageurl") String imageurl,
							@RequestParam("photo") MultipartFile image) {

		Post post = new Post();
		post.setId(post_id);
		post.setTopic(topic);
		post.setAuthor(author);
		post.setDescription(description);
		post.setContent(content);
		post.setImage(imageurl);
		String tags = null;
		postsService.updatePost(post, tags, image);
		return "redirect:/admin/posts";
	}

	@RequestMapping(value = "/admin/post/delete/{post_id}", method = RequestMethod.POST)
	public String deletePost(@PathVariable int post_id) {
		postsService.deletePost(post_id);
		postsCount--;
		return "redirect:/admin/posts";
	}

}
