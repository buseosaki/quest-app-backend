package com.example.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.entities.User;
import com.example.questapp.repos.UserRepository;
import com.example.questapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	//önce repoyu tanimla
	private UserService userService; //esittirli bir sey yazmadık.
	// spring userRepositorynin beanini bulup inject edecek. bunu constructor injectle apabiliriz.
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping //getirmek için
	public List<User> getAllUsers() {
		return userService.getAllUsers();
		//getAllUsers'i userservice kısmında tanımlıyoruz
	}
	
	@PostMapping //create etmek için - post isteği geldiğinde bu method çağırılır
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userService.getOneUser(userId);
	}
	
	//ID creationunu yapamayız kendimiz vermek siteriz o yuzden postmapping yapamayız.
	//Onun yerine varolan idli bir useri değiştirebiliriz.
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId,newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	
	}

