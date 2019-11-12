package ru.vallball.school01.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.school01.dao.UserRepository;
import ru.vallball.school01.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Аутентифицируем service...");
		User user = userRepository.findUserByUsername(username);
		if (user != null)
			return user;
		throw new UsernameNotFoundException("Пользователь " + username + " не найден");
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public void update(User user) {
		userRepository.save(user);

	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}

}
