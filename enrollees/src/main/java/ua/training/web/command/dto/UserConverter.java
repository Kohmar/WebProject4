package ua.training.web.command.dto;

import org.apache.log4j.Logger;
import ua.training.dao.impl.EnrolleeDAOImpl;
import ua.training.entity.User;


/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class UserConverter {

	
	private static volatile UserConverter instance = null;

	private static final Logger LOGGER = Logger.getLogger(UserConverter.class);

	public static synchronized UserConverter getInstance() {
		if (instance == null) {
			instance = new UserConverter();
		}
		return instance;
	}

	public UserDto convert(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setLogin(user.getLogin());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		dto.setBlocked(new EnrolleeDAOImpl().getStatusOfEnrollee(user.getId()));
		dto.setEnrolleeExist(new EnrolleeDAOImpl().isEnrolleeExists(user.getId()));
		LOGGER.trace("user dto  = " + dto);
		return dto;

	}
}
