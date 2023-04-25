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

	public List<Post> getAllPosts(Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}

	public Post getOnePostById(Long postId) {
		
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(Post newPost) {
		return postRepository.save(newPost);
	}
	
	
		
	
	}
