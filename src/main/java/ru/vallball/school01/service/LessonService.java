package ru.vallball.school01.service;

import java.util.List;

import ru.vallball.school01.model.Lesson;


public interface LessonService {
	
	void save(Lesson lesson);

	List<Lesson> list();

	void delete(Long id);

	void update(Lesson lesson);

	Lesson findById(Long id);
}
