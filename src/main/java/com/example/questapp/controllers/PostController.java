package com.example.questapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.services.PostService;

@RestController
@RequestMapping("/posts")

public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
}
