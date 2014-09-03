package com.aboutme.blog.controllers;

import com.aboutme.blog.models.Tag;
import com.aboutme.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TagsController {

	private TagService tagService;

	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	@RequestMapping(value = "/admin/tags", method = RequestMethod.GET)
	public String showTags(Model model) {
		model.addAttribute("tags", tagService.getTags());
		return "/admin/tags";
	}

	@RequestMapping(value = "admin/tags", method = RequestMethod.POST)
	public void addTag(@RequestParam("tag") String tagName) {
		Tag tag = new Tag();
		tag.setTagName(tagName);
		tag.setPopularity(0);
		tagService.addTag(tag);
	}

	public void deleteTag() {

	}
}
