package ua.nure.helperk.service;

import ua.nure.helperk.entity.UserRole;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface UserRoleService {
	
	void add(UserRole UserRole);

	void update(UserRole UserRole);

	void delete(UserRole UserRole);

	UserRole findUserRoleByName(String name);

	List<UserRole> getAllUserRoles();
}
