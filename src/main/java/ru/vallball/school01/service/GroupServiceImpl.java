package ru.vallball.school01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.school01.dao.GroupRepository;
import ru.vallball.school01.model.Group;


@Service
@Transactional
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupRepository groupRepository;
	
	@Override
	public void save(Group group) {
		groupRepository.save(group);
		
	}

	@Override
	public List<Group> list() {
		return groupRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		groupRepository.deleteById(id);;
		
	}

	@Override
	public void update(Group group) {
		groupRepository.save(group);
		
		
	}

	@Override
	public Group findGroupById(Long id) {
		return groupRepository.findById(id).get();
	}

}
