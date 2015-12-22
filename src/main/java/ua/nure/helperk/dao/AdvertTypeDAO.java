package ua.nure.helperk.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import ua.nure.helperk.entity.AdvertType;

/**
 * @author Oleg Dashkevych.
 */
public interface AdvertTypeDAO extends GenericDAO<AdvertType, Long> {

	AdvertType getByName(String name);
}
