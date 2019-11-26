package ru.vallball.school01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.school01.dao.DayScheduleRepository;
import ru.vallball.school01.model.DaySchedule;

@Service
@Transactional
public class DayScheduleServiceImpl implements DayScheduleService{

	@Autowired
	DayScheduleRepository dayScheduleRepository;
	
	@Override
	public void save(DaySchedule daySchedule) {
		dayScheduleRepository.save(daySchedule);
		
	}

	@Override
	public List<DaySchedule> list() {
		return dayScheduleRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		dayScheduleRepository.deleteById(id);
	}

	@Override
	public void update(DaySchedule daySchedule) {
		dayScheduleRepository.save(daySchedule);		
	}

	@Override
	public DaySchedule findById(Long id) {
		return dayScheduleRepository.findById(id).get();
	}

}
