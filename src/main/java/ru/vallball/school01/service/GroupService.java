package ru.vallball.school01.service;

import java.util.List;

import ru.vallball.school01.model.Group;

public interface GroupService {

	void save(Group group);

	List<Group> list();

	void delete(Long id);

	void update(Group group);

	Group findGroupById(Long id);
}
