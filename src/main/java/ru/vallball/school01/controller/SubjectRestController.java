package ru.vallball.school01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.school01.model.Subject;
import ru.vallball.school01.service.SubjectService;

@RestController
@RequestMapping(value = "/subjects", produces = "application/json")
public class SubjectRestController {

	@Autowired
	SubjectService subjectService;

	@GetMapping
	@ResponseBody
	public List<Subject> list() {
		return subjectService.list();
	}

	@PostMapping
	public ResponseEntity<Object> createGroup(@Valid @RequestBody Subject subject) {
		subjectService.save(subject);
		return new ResponseEntity<>("Subject is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClass(@PathVariable(value = "id") Long id, @RequestBody Subject subject) {
		try {
			Subject subjectForUpdate = subjectService.findSubjectById(id);
			subjectForUpdate.setName(subject.getName());
			subjectService.save(subjectForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Subject not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Subject is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTour(@PathVariable(value = "id") Long id) {
		try {
			subjectService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Subject not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Subject is deleted successfully", HttpStatus.ACCEPTED);
	}
}
