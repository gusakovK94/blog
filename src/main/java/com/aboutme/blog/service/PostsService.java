package com.aboutme.blog.service;

import com.aboutme.blog.dao.interfaces.PostsDao;
import com.aboutme.blog.exceptions.ImageUploadException;
import com.aboutme.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Component
public class PostsService {

	private PostsDao postsDao;

	@Autowired
	public void setPostsDao(PostsDao postsDao) {
		this.postsDao = postsDao;
	}

	public void savePost(Post post, String tags, MultipartFile image) {
		try {
			if (!image.isEmpty()) {
				validateImage(image);

				post.setImage(saveImage(image, image.getOriginalFilename()));
			}
		} catch (ImageUploadException e) {
			e.printStackTrace();
		}
		post.setDate(new Date());
		postsDao.add(post);
	}

	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg"))
			throw new ImageUploadException("Only JPG images accepted");
	}

	private String saveImage(MultipartFile image, String filename) {
		String fullFileName = "/Users/kirill_gusakov/development/Java/Development/blog/src/main/webapp/resources/images/" + filename;
		try {
			File file = new File(fullFileName);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(image.getBytes());
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullFileName;
	}

}
