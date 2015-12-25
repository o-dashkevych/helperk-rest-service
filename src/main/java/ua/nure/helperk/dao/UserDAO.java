package ua.nure.helperk.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import ua.nure.helperk.entity.User;

public interface UserDAO extends GenericDAO<User, Long> {

	Boolean authenticate(String email, String password);

	User findByEmail(String email);

}
