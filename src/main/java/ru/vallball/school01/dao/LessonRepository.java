package ru.vallball.school01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.school01.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{

}
