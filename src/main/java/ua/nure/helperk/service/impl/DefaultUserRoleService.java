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
public class DefaultUserRoleService implements UserRoleService{


	@Autowired
	private UserRoleDAO roleDAO;

	@Override
	public void add(UserRole userRole) {
		roleDAO.save(userRole);
	}

	@Override
	public void update(UserRole userRole) {
		roleDAO.save(userRole);
	}

	@Override
	public void delete(UserRole userRole) {
		roleDAO.remove(userRole);
	}

	@Override
	public UserRole findUserRoleByName(String name) {
		return roleDAO.getByName(name);
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return roleDAO.findAll();
	}
}
