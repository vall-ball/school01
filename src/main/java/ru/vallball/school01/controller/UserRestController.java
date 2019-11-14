package ru.vallball.school01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.school01.model.User;
import ru.vallball.school01.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserRestController {

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@GetMapping
	@ResponseBody
	public List<User> list() {
		return userService.list();
	}

	@PostMapping
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		userService.save(user.toUser(passwordEncoder));
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
		try {
			User userForUpdate = userService.findUserById(id);
			userForUpdate.setDateOfBirth(user.getDateOfBirth());
			userForUpdate.setGender(user.getGender());
			userForUpdate.setName(user.getName());
			userForUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
			userForUpdate.setPatronymic(user.getPatronymic());
			userForUpdate.setRole(user.getRole());
			userForUpdate.setSurname(user.getSurname());
			userForUpdate.setUsername(user.getUsername());
			userService.save(userForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTour(@PathVariable(value = "id") Long id) {
		try {
			userService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User is deleted successfully", HttpStatus.ACCEPTED);
	}

}
