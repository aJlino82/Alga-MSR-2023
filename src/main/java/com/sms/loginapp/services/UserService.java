package com.sms.loginapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.loginapp.models.User;
import com.sms.loginapp.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> findByName(String name) {
		return userRepository.findByNameContaining(name);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
