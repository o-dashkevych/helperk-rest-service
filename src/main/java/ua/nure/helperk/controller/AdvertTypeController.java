package ua.nure.helperk.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.helperk.entity.AdvertType;
import ua.nure.helperk.service.AdvertTypeService;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@RestController
@RequestMapping("/advert_type")
public class AdvertTypeController {

	private static final Logger LOGGER = Logger.getLogger(AdvertTypeController.class);

	@Autowired
	private AdvertTypeService advertTypeService;

	@RequestMapping("/get")
	public AdvertType getRole(@RequestParam(value = "name") String name) {
		LOGGER.info("get advertType for name - >" + name);
		return advertTypeService.findAdvertTypeByName(name);
	}

	@RequestMapping("/all")
	public List<AdvertType> getAll() {
		List<AdvertType> advertTypes = advertTypeService.getAllAdvertTypes();
		LOGGER.info("all advertTypes size: " + advertTypes.size());
		return advertTypes;
	}
}