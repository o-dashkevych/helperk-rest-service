package ua.nure.helperk.service;

import ua.nure.helperk.entity.Advert;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface AdvertService {

	void add(Advert advert);

	void update(Advert advert);

	void delete(Advert advert);

	Advert getById(Long id);

	List<Advert> getAllAdverts();
}
