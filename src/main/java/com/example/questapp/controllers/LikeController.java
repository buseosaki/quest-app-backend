package com.example.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.entities.Like;
import com.example.questapp.services.LikeService;

@RestController
@RequestMapping("/likes")

public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@GetMapping
	public List<Like> getAllLikes(@RequestParam Optional <Long> postId){
		return likeService.getAllLikes();
	}
	
	
	
	
	
}
