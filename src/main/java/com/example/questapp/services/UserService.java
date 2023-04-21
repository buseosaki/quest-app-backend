package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

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

	public User saveOneUser(User newUser) {
		
		return userRepository.save(newUser);
	}

	public User getOneUser(Long userId) {
		
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
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

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
		
	}

}
