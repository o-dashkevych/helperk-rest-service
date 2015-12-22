package ua.nure.helperk.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import ua.nure.helperk.entity.UserRole;

/**
 * @author Oleg Dashkevych.
 */
public interface UserRoleDAO extends GenericDAO<UserRole, Long> {

	UserRole getByName(String name);
}
