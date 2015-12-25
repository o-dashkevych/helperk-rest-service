package ua.nure.helperk.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.helperk.dao.AdvertTypeDAO;
import ua.nure.helperk.entity.AdvertType;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * @author Oleg Dashkevych.
 */
@Repository
@Transactional
public class DefaultAdvertTypeDao extends GenericDAOImpl<AdvertType, Long> implements AdvertTypeDAO {


	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public AdvertType getByName(String name) {
		Criteria criteria = getSession().createCriteria(AdvertType.class);
		criteria.add(eq("name", name));
		return (AdvertType) criteria.uniqueResult();
	}
}
