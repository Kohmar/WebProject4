package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.FacultyDAO;
import ua.training.dao.impl.FacultyDAOImpl;
import ua.training.entity.Faculty;
import ua.training.web.ActionType;
import ua.training.web.Path;
import ua.training.web.command.dto.FacultyConverter;
import ua.training.web.command.dto.FacultyDto;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class ListFacultiesCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4977863813985209973L;
	
	private static final Logger LOG = Logger.getLogger(ListFacultiesCommand.class);


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");
		
		String result = null;
		
		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		}
		
		LOG.debug("Finished executing Command");
		return result;
	}
	
	
	private String doGet(HttpServletRequest request,
			HttpServletResponse response) {
		
		FacultyDAO facultydao = new FacultyDAOImpl();
		List<Faculty> faculties = facultydao.getAllFaculty();
		
		List<FacultyDto> facultiesDtos = new ArrayList<FacultyDto>();
		for (Faculty faculty: faculties) {
			facultiesDtos.add(FacultyConverter.getInstance().convert(faculty));
		}
		
		LOG.trace("faculties were found : " + facultiesDtos);
		request.getSession().setAttribute("faculties", facultiesDtos);		
		return Path.FORWARD_VIEW_ALL_FACULTY;
	}

}
