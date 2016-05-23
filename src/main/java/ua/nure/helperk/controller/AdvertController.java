package ua.nure.helperk.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.helperk.entity.Advert;
import ua.nure.helperk.entity.AdvertType;
import ua.nure.helperk.entity.User;
import ua.nure.helperk.service.AdvertService;
import ua.nure.helperk.service.AdvertTypeService;
import ua.nure.helperk.service.UserService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@RestController
@RequestMapping("/advert")
public class AdvertController {

	private static final Logger LOGGER = Logger.getLogger(AdvertController.class);

	@Autowired
	private AdvertService advertService;

	@Autowired
	private AdvertTypeService advertTypeService;

	@Autowired
	private UserService userService;

	@RequestMapping("/all")
	public List<Advert> getAll() {
		List<Advert> adverts = advertService.getAllAdverts();
		LOGGER.info("all adverts size: " + adverts.size());
		return adverts;
	}

	@RequestMapping("/add")
	public Advert addAdvert(@RequestParam(value = "creator") String creatorEmail,
							@RequestParam(value = "title") String title,
							@RequestParam(value = "description") String description,
							@RequestParam(value = "startDate") String startDate,
							@RequestParam(value = "price") String price,
							@RequestParam(value = "type") String type) {
		AdvertType advertType = advertTypeService.findAdvertTypeByName(type);
		User creator = userService.findByEmail(creatorEmail);
		try {
			Advert advert = new Advert(title, description, new Timestamp(Long.parseLong(startDate)),
					null, Double.parseDouble(price), creator, null, advertType, null);
			System.out.println("Trying to add advert with creator email: " + creator.getEmail());
			advertService.add(advert);
			return advert;
		} catch (NumberFormatException e) {
			System.out.println("Advert add exception -> Number format");
			return null;
		}
	}

	@RequestMapping("/get")
	public Advert getAdvert(@RequestParam(value = "id") String advert_id) {
		try {
			Long id = new Long(advert_id);
			return advertService.getById(id);
		} catch (NumberFormatException e) {
			System.out.println("Invalid id number");
		}
		return null;
	}

	@RequestMapping("/execute")
	public Advert executeAdvert(@RequestParam(value = "id") Long advert_id,
								@RequestParam(value = "executor") Long exec_id) {
		try {
			Long id = advert_id;
			Advert advert = advertService.getById(id);
			User executor = userService.findUserById(exec_id);
			advert.setExecutor(executor);
			return advert;
		} catch (NumberFormatException e) {
			System.out.println("Invalid id number");
		}
		return null;
	}
}
