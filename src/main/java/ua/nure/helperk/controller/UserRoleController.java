package ua.nure.helperk.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.helperk.entity.UserRole;
import ua.nure.helperk.service.UserService;

/**
 * @author Oleg Dashkevych.
 */

@RestController
@RequestMapping("/user_role")
public class UserRoleController {

	private static final Logger LOGGER = Logger.getLogger(UserRoleController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/get")
	public UserRole getRole(@RequestParam(value = "email") String email) {
		LOGGER.info("get role for email - >" + email);
		return userService.findUserRoleByEmail(email);
	}
}
