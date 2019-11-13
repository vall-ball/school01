package ru.vallball.school01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.school01.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{

}
