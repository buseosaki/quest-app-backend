package com.example.questapp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {

	Long userId;
	Long postId;
	Long Id;
}
