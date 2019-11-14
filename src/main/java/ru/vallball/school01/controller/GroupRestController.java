package ru.vallball.school01.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
