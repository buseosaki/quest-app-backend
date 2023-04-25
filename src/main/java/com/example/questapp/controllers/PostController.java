package com.example.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.entities.Post;
import com.example.questapp.services.PostService;

@RestController
@RequestMapping("/posts")

public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	//request param, pathteki id'yi parcalayip alip degiskene atar.
	//optional, gelebilir, gelmeye de bilir.
	//optional gelmezse tum postlari cagir.
	public List<Post> getAllPosts(@RequestParam Optional <Long> userId){
		return postService.getAllPosts(userId);
	}
	
	@PutMapping
	public Post createOnePost(@RequestBody Post newPost) {
		return postService.createOnePost(newPost);
	}
	
	
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
}