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
import ru.vallball.school01.model.Group;
import ru.vallball.school01.service.GroupService;

@RestController
@RequestMapping(value = "/classes", produces = "application/json")
public class GroupRestController {

	@Autowired
	GroupService groupService;

	@GetMapping
	@ResponseBody
	public List<Group> list() {
		return groupService.list();
	}

	@PostMapping
	public ResponseEntity<Object> createGroup(@Valid @RequestBody Group group) {
		groupService.save(group);
		return new ResponseEntity<>("Class is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClass(@PathVariable(value = "id") Long id, @RequestBody Group group) {
		try {
			Group groupForUpdate = groupService.findGroupById(id);
			groupForUpdate.setName(group.getName());
			groupForUpdate.setTeacher(group.getTeacher());
			groupForUpdate.setUsers(group.getUsers());
			groupService.save(groupForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Group not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Group is udated successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTour(@PathVariable(value = "id") Long id) {
		try {
			groupService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Group not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Group is deleted successfully", HttpStatus.ACCEPTED);
	}

}
