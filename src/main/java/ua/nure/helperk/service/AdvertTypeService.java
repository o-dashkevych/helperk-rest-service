package ua.nure.helperk.service;

import ua.nure.helperk.entity.AdvertType;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface AdvertTypeService {

	void add(AdvertType advertType);

	void update(AdvertType advertType);

	void delete(AdvertType advertType);

	List<AdvertType> getAllAdvertTypes();
}
