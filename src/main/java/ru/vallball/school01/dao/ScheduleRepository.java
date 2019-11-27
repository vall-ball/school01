package ru.vallball.school01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.school01.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
