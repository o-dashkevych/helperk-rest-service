package ua.nure.helperk.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.helperk.dao.AdvertTypeDAO;
import ua.nure.helperk.entity.AdvertType;

/**
 * @author Oleg Dashkevych.
 */
@Repository
@Transactional
public class DefaultAdvertTypeDao extends GenericDAOImpl<AdvertType, Long> implements AdvertTypeDAO{

	@Override
	public AdvertType getByName(String name) {
		return null;
	}
}
