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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.school01.model.DaySchedule;
import ru.vallball.school01.service.DayScheduleService;
import ru.vallball.school01.service.LessonService;

@RestController
@RequestMapping(value = "/dayschedules", produces = "application/json")
public class DayScheduleController {

	@Autowired
	DayScheduleService dayScheduleService;

	@Autowired
	LessonService lessonService;

	private static final Logger logger = LoggerFactory.getLogger(DayScheduleController.class);

	@GetMapping
	@ResponseBody
	public List<DaySchedule> list() {
		return dayScheduleService.list();
	}

	@PostMapping
	public ResponseEntity<Object> createDaySchedule(@Valid @RequestBody DaySchedule daySchedule) {
		// logger.info(daySchedule.getSchedules().toString());
		/*
		 * for (Lesson lesson : daySchedule.getLessons()) { lessonService.save(lesson);
		 * }
		 */
		dayScheduleService.save(daySchedule);
		return new ResponseEntity<>("DaySchedule is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateClass(@PathVariable(value = "id") Long id,
			@RequestBody DaySchedule daySchedule) {
		try {
			DaySchedule dayScheduleForUpdate = dayScheduleService.findById(id);
			dayScheduleForUpdate.setDayOfWeek(daySchedule.getDayOfWeek());
			dayScheduleForUpdate.setLessons(daySchedule.getLessons());
			dayScheduleService.save(dayScheduleForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("DaySchedule not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("DaySchedule is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTour(@PathVariable(value = "id") Long id) {
		try {
			dayScheduleService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("DaySchedule not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("DaySchedule is deleted successfully", HttpStatus.ACCEPTED);
	}

}
