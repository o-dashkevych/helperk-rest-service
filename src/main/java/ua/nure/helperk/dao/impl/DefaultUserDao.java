package ua.nure.helperk.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.helperk.dao.UserDAO;
import ua.nure.helperk.entity.User;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class DefaultUserDao extends GenericDAOImpl<User, Long> implements UserDAO {


	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Boolean authenticate(String email, String password) {
		Criteria criteria = makeAuthCriteria(email, password);
		return criteria.uniqueResult() != null;
	}

	private Criteria makeAuthCriteria(String email, String password){
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(eq("email", email));
		criteria.add(eq("password", password));
		return criteria;
	}

	@Override
	public User findByEmail(String email) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(eq("email", email));
		return (User) criteria.uniqueResult();
	}
}
