package ru.vallball.school01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.school01.model.DaySchedule;

public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long>{

}
