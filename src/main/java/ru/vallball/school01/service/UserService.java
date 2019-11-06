package ru.vallball.school01.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ru.vallball.school01.model.User;

public interface UserService extends UserDetailsService {
	void save(User user);

	List<User> list();

	void delete(Long id);

	void update(User user);

	User findUserById(Long id);
}
