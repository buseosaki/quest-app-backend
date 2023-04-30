package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.Comment;
import com.example.questapp.repos.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;

	public List<Comment> getAllComments(Optional<Long> userId) {
		return commentRepository.findAll();
	}
}
