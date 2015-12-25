package ua.nure.helperk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.helperk.dao.UserDAO;
import ua.nure.helperk.entity.User;
import ua.nure.helperk.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void add(User user) {
		userDAO.save(user);
	}

	@Override
	public void update(User user) {
		userDAO.save(user);
	}

	@Override
	public void delete(User user) {
		userDAO.remove(user);
	}

	@Override
	public User findUserById(Long id) {
		return userDAO.find(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public Boolean authenticate(String email, String password) {
		return userDAO.authenticate(email, password);
	}
}
