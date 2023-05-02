package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repos.CommentRepository;
import com.example.questapp.requests.CommentCreateRequest;
import com.example.questapp.requests.CommentUpdateRequest;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;
	
	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdandPostId(userId.get(), postId.get());
		}
		else if(userId.isPresent()) {
				return commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else 
		  return commentRepository.findAll();
		
	}
	
	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}
	

	public Comment createOneComment(CommentCreateRequest newCreateRequest) {
		//önce varlar mı diye kontrol edelim
		User user = userService.getOneUserById(newCreateRequest.getUserId());
		Post post = postService.getOnePostById(newCreateRequest.getPostId());
		if(user != null & post != null) {
			//varlarsa comment objesi oluşturuyoruz.
			Comment commentToSave = new Comment();
			commentToSave.setId(newCreateRequest.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(newCreateRequest.getText());
			return commentRepository.save(commentToSave);
		}else
		return null;
	}

	public Comment updateOneCommentById(long commentId, CommentUpdateRequest request) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(request.getText());
			return commentRepository.save(commentToUpdate);
		}else
		return null;
		
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}



	

	
}
