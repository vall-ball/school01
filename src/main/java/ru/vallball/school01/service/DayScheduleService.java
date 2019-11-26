package ru.vallball.school01.service;

import java.util.List;

import ru.vallball.school01.model.DaySchedule;

public interface DayScheduleService {
	
	void save(DaySchedule daySchedule);

	List<DaySchedule> list();

	void delete(Long id);

	void update(DaySchedule daySchedule);

	DaySchedule findById(Long id);
}


