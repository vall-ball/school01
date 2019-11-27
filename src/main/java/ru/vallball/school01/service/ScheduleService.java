package ru.vallball.school01.service;

import java.util.List;

import ru.vallball.school01.model.Schedule;

public interface ScheduleService {

	void save(Schedule schedule);

	List<Schedule> list();

	void delete(Long id);

	void update(Schedule schedule);

	Schedule findById(Long id);
}
