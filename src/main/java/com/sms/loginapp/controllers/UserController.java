package com.sms.loginapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sms.loginapp.models.User;
import com.sms.loginapp.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> listAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> listById(@PathVariable("id") long id) {
		return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@Valid @PathVariable long id, @RequestBody User user) {
		if (!userService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		user = userService.save(user);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {
		if (!userService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
