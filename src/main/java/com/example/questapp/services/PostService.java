package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.questapp.entities.Post;
import com.example.questapp.repos.PostRepository;

@Service
public class PostService {
	//repo çağır
	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional <Long> userId){
		return postService.getAllPosts(userId);
		
	}
	}
