package ua.nure.helperk.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.helperk.config.Roles;
import ua.nure.helperk.entity.User;
import ua.nure.helperk.entity.UserRole;
import ua.nure.helperk.service.UserRoleService;
import ua.nure.helperk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping("/get")
	public User get(@RequestParam(value = "email") String email) {
		LOGGER.info("email -> " + email);
		return userService.findByEmail(email);
	}

	@RequestMapping("/auth")
	public boolean authenticate(@RequestParam(value = "email") String email,
								@RequestParam(value = "password") String password) {
		System.out.println("Tyring to login user with email: " + email);
		return userService.authenticate(email, password);
	}

	@RequestMapping("/add")
	public User addUser(@RequestParam(value = "name") String name,
						@RequestParam(value = "email") String email,
						@RequestParam(value = "password") String password) {
		UserRole role = userRoleService.findUserRoleByName(Roles.USER.name());
		User user = new User(name, email, password, role);
		System.out.println("Tyring to add user with email: " + email + "name: " + name);
		userService.add(user);

		return user;
	}
}
