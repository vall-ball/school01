package ru.vallball.school01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.school01.dao.ScheduleRepository;
import ru.vallball.school01.model.Schedule;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Override
	public void save(Schedule schedule) {
		scheduleRepository.save(schedule);
		
	}

	@Override
	public List<Schedule> list() {
		return scheduleRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		scheduleRepository.deleteById(id);
		
	}

	@Override
	public void update(Schedule schedule) {
		scheduleRepository.save(schedule);
		
	}

	@Override
	public Schedule findById(Long id) {
		return scheduleRepository.findById(id).get();
	}

}
