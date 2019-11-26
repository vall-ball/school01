package ru.vallball.school01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.school01.dao.LessonRepository;
import ru.vallball.school01.model.Lesson;

@Service
@Transactional
public class LessonServiceImpl implements LessonService{

	@Autowired
	LessonRepository lessonRepository;
	
	@Override
	public void save(Lesson lesson) {
		lessonRepository.save(lesson);
		
	}

	@Override
	public List<Lesson> list() {
		return lessonRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		lessonRepository.deleteById(id);
		
	}

	@Override
	public void update(Lesson lesson) {
		lessonRepository.save(lesson);
		
	}

	@Override
	public Lesson findById(Long id) {
		return lessonRepository.findById(id).get();
	}
	
}
