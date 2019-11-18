package ru.vallball.school01.service;

import java.util.List;

import ru.vallball.school01.model.Subject;


public interface SubjectService {

	void save(Subject subject);

	List<Subject> list();

	void delete(Long id);

	void update(Subject subject);

	Subject findSubjectById(Long id);
}
