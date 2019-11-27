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

import ru.vallball.school01.model.Schedule;
import ru.vallball.school01.service.ScheduleService;

@RestController
@RequestMapping(value = "/schedules", produces = "application/json")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping
	@ResponseBody
	public List<Schedule> list() {
		return scheduleService.list();
	}

	@PostMapping
	public ResponseEntity<Object> createDaySchedule(@Valid @RequestBody Schedule schedule) {
		scheduleService.save(schedule);
		return new ResponseEntity<>("Schedule is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
			@RequestBody Schedule schedule) {
		try {
			Schedule scheduleForUpdate = scheduleService.findById(id);
			scheduleForUpdate.setDaySchedules(schedule.getDaySchedules());
			scheduleForUpdate.setGroup(schedule.getGroup());
			scheduleService.save(scheduleForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Schedule not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Schedule is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTour(@PathVariable(value = "id") Long id) {
		try {
			scheduleService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Schedule not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Schedule is deleted successfully", HttpStatus.ACCEPTED);
	}


}
