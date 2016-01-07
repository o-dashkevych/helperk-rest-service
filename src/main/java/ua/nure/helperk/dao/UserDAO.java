package ua.nure.helperk.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import ua.nure.helperk.entity.User;
import ua.nure.helperk.entity.UserRole;

public interface UserDAO extends GenericDAO<User, Long> {

	Boolean authenticate(String email, String password);

	User findByEmail(String email);

	UserRole getRoleByName(String email);
}
