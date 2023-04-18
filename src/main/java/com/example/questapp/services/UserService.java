package com.example.questapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.User;
import com.example.questapp.repos.UserRepository;

@Service
//repoya bağlanalım.
public class UserService {
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		// burada repoya bağlanacağız
		return userRepository.findAll();
	}

}
