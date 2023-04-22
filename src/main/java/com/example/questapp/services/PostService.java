package com.example.questapp.services;

import org.springframework.stereotype.Service;

import com.example.questapp.repos.PostRepository;

@Service
public class PostService {
	//repo çağır
	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
}
