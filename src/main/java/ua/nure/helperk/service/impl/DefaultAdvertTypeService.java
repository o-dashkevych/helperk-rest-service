package ua.nure.helperk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.helperk.dao.AdvertTypeDAO;
import ua.nure.helperk.entity.AdvertType;
import ua.nure.helperk.service.AdvertTypeService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */

@Service
@Transactional
public class DefaultAdvertTypeService implements AdvertTypeService {

	@Autowired
	private AdvertTypeDAO advertTypeDAO;

	@Override
	public void add(AdvertType userRole) {
		advertTypeDAO.save(userRole);
	}

	@Override
	public void update(AdvertType userRole) {
		advertTypeDAO.save(userRole);
	}

	@Override
	public void delete(AdvertType userRole) {
		advertTypeDAO.remove(userRole);
	}

	@Override
	public List<AdvertType> getAllAdvertTypes() {
		return advertTypeDAO.findAll();
	}
}
