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

@RestController
@RequestMapping("/users")
public class UserController {

	//önce repoyu tanimla
	private UserRepository userRepository; //esittirli bir sey yazmadık.
	// spring userRepositorynin beanini bulup inject edecek. bunu constructor injectle apabiliriz.
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@GetMapping //getirmek için
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping //create etmek için - post isteği geldiğinde bu method çağırılır
	public User createUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userRepository.findById(userId).orElse(null);
	}
	
	//ID creationunu yapamayız kendimiz vermek siteriz o yuzden postmapping yapamayız.
	//Onun yerine varolan idli bir useri değiştirebiliriz.
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
	//update etmek için önce o user'ı bulmalıyız.
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get(); //optional oldugu icin olusturulan useri get ile alıyoruz
			//sonra foundUser üzerinde update işlemi yapılacak.
			foundUser.setUserName(newUser.getUserName()); //parametreye requestbody newUser ekledik
			foundUser.setPassword(newUser.getPassword());
			
			//update edilen halini database'e save edelim
			userRepository.save(foundUser);
			return foundUser;
			
		}else
			return null;
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userRepository.deleteById(userId);
	}
	
	}

