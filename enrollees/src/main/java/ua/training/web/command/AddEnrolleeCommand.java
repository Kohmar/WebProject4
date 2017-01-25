package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.EnrolleeDAO;
import ua.training.dao.impl.DAOFactoryImpl;
import ua.training.entity.Enrollee;
import ua.training.entity.User;
import ua.training.web.ActionType;
import ua.training.web.Path;
import ua.training.web.utils.BecomeEnrolleeFieldValidator;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class AddEnrolleeCommand extends Command {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 4154498265134492717L;
	
	private static final Logger LOG = Logger.getLogger(AddEnrolleeCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
	 		throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} else if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}

		LOG.debug("Finished executing Command");

		return result;
	}
	
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Request for only showing addEnrolleeForm.jsp");
		return Path.FORWARD_ENROLLEE_ADD;
	}
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Statring adding enrollee");
		String city = request.getParameter("city");
		byte[] bytes = city.getBytes(StandardCharsets.ISO_8859_1);
		city = new String(bytes, StandardCharsets.UTF_8);
		String region = request.getParameter("region");
		byte[] bytes1 = region.getBytes(StandardCharsets.ISO_8859_1);
		region = new String(bytes1, StandardCharsets.UTF_8);
		LOG.trace("fields were got : " + city + " ," + region);
		
		String result = null;
		boolean valid = BecomeEnrolleeFieldValidator.isValidCityAndRegion(city, region);
		if(valid == true) {
		User user = (User) request.getSession().getAttribute("user");
		LOG.trace("User was got from session: " + user);
		Integer id = user.getId();
		Enrollee enrollee = new Enrollee(city,region,id,false);
		EnrolleeDAO enrolledao = new DAOFactoryImpl().getEnrolleeDAO();
		enrolledao.addEnrollee(enrollee);
		request.getSession().setAttribute("enrollee", enrollee);
		LOG.trace("Enrollee was added to database");
		 result = Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
		} else {
		LOG.error("Not valid city and region! Please, try again");

		result = Path.REDIRECT_TO_SHOW_ADD_ENROLLEE;
		}
		 return result;
		 
		 
	}
	
	
	

}
