package ru.vallball.school01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.school01.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
}
