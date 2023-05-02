package com.example.questapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.Like;
import com.example.questapp.repos.LikeRepository;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;

	public List<Like> getAllLikes(){
		return likeRepository.findAll();

}
}