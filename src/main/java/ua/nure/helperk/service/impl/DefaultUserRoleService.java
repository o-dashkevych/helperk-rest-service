package ua.nure.helperk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.helperk.dao.UserRoleDAO;
import ua.nure.helperk.entity.UserRole;
import ua.nure.helperk.service.UserRoleService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */

@Service
@Transactional
public class DefaultUserRoleService implements UserRoleService {


	@Autowired
	private UserRoleDAO userRoleDAO;

	@Override
	public void add(UserRole userRole) {
		userRoleDAO.save(userRole);
	}

	@Override
	public void update(UserRole userRole) {
		userRoleDAO.save(userRole);
	}

	@Override
	public void delete(UserRole userRole) {
		userRoleDAO.remove(userRole);
	}

	@Override
	public UserRole findUserRoleByName(String name) {
		return userRoleDAO.getByName(name);
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return userRoleDAO.findAll();
	}
}
