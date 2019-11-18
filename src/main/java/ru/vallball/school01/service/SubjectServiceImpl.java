package ru.vallball.school01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.school01.dao.SubjectRepository;
import ru.vallball.school01.model.Subject;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public void save(Subject subject) {
		subjectRepository.save(subject);
		
	}

	@Override
	public List<Subject> list() {
		return subjectRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		subjectRepository.deleteById(id);
		
	}

	@Override
	public void update(Subject subject) {
		subjectRepository.save(subject);
	}

	@Override
	public Subject findSubjectById(Long id) {
		return subjectRepository.findById(id).get();
	}
	
	
}
