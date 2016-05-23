package ua.nure.helperk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.helperk.dao.AdvertDAO;
import ua.nure.helperk.entity.Advert;
import ua.nure.helperk.service.AdvertService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */

@Service
@Transactional
public class DefaultAdvertService implements AdvertService {

	@Autowired
	private AdvertDAO advertDAO;

	@Override
	public void add(Advert advert) {
		advertDAO.save(advert);
	}

	@Override
	public void update(Advert advert) {
		advertDAO.save(advert);
	}

	@Override
	public void delete(Advert advert) {
		advertDAO.remove(advert);
	}

	@Override
	public Advert getById(Long id) {
		return advertDAO.find(id);
	}

	@Override
	public List<Advert> getAllAdverts() {
		return advertDAO.findAll();
	}
}
