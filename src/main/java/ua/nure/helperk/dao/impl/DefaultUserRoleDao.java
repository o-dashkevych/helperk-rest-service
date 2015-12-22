package ua.nure.helperk.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.helperk.dao.UserRoleDAO;
import ua.nure.helperk.entity.User;
import ua.nure.helperk.entity.UserRole;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * @author Oleg Dashkevych.
 */

@Repository
@Transactional
public class DefaultUserRoleDao extends GenericDAOImpl<UserRole, Long> implements UserRoleDAO {

	@Override
	public UserRole getByName(String name) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(eq("name", name));
		return (UserRole) criteria.uniqueResult();
	}
}
