package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.web.ActionType;
import ua.training.web.Path;
import ua.training.web.command.dto.FacultyDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class SortFacultyByBudgetSeats extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019246685808915282L;
	
	private static final Logger LOG = Logger.getLogger(SortFacultyByBudgetSeats.class);

	
	private static final Comparator<FacultyDto> SORT_FACULTY_BY_BUDGET_SEATS = new Comparator<FacultyDto>() {
		
		@Override
		public int compare(FacultyDto o1, FacultyDto o2) {
			return o1.getBudgetSeats() - o2.getBudgetSeats();
		}
	};
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");
		
		String result = null;
		
		if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}
		
		LOG.debug("Finished executing Command");
		return result;
	}
	
	private String doPost(HttpServletRequest request,
			HttpServletResponse response) {
		LOG.trace("Starting sorting faculties using Comporator");
//		FacultyDAO facultydao = new DAOFactoryImpl().getFacultyDAO();
//		List<Faculty> faculties = facultydao.getAllFaculty();
		List<FacultyDto> faculties = (List<FacultyDto>) request.getSession().getAttribute("faculties");
		Collections.sort(faculties, SORT_FACULTY_BY_BUDGET_SEATS);
		request.getSession().setAttribute("faculties", faculties);
		LOG.trace("Faculties are sorted successfully");
		return Path.REDIRECT_TO_SHOW_SORTED_BY_NAME;
	}

}
