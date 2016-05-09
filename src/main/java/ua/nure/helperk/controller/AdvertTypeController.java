package ua.nure.helperk.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.helperk.entity.AdvertType;
import ua.nure.helperk.service.AdvertTypeService;

@RestController
@RequestMapping("/user")
public class AdvertTypeController {

	private static final Logger LOGGER = Logger.getLogger(AdvertTypeController.class);

	@Autowired
	private AdvertTypeService advertTypeService;

	@RequestMapping("/get")
	public AdvertType get(@RequestParam(value = "name") String name) {
		LOGGER.info("name -> " + name);
		return advertTypeService.getByName(name);
	}

	@RequestMapping("/add")
	public Boolean add(@RequestParam(value = "name") String name) {
		LOGGER.info("name -> " + name);
		if(existAdvertType(name)) {
			advertTypeService.add(new AdvertType(name));
			return true;
		}else return false;
	}

	private Boolean existAdvertType(String name){
		return advertTypeService.getByName(name) != null;
	}

	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "name") String name) {
		LOGGER.info("name -> " + name);
		advertTypeService.delete(new AdvertType(name));
	}
}
