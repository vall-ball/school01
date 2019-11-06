package ru.vallball.school01.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.school01.model.User;
import ru.vallball.school01.service.UserService;

@RestController
@RequestMapping("/buses")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> createBus(@Valid @RequestBody User user) {
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}
	
}
