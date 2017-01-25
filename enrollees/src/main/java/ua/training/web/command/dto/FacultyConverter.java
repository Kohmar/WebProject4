package ua.training.web.command.dto;

import org.apache.log4j.Logger;
import ua.training.dao.impl.DAOFacultyEnrolleeImpl;
import ua.training.entity.Faculty;


/**
 * Created by Kotov Nicholas on 25.01.2017.
 */

/**
 * Faculty DTO realization.
 */
public class FacultyConverter {

	private static volatile FacultyConverter instance = null;

	private static final Logger LOGGER = Logger.getLogger(FacultyConverter.class);

	public static synchronized FacultyConverter getInstance() {
		if (instance == null) {
			instance = new FacultyConverter();
		}
		return instance;
	}

	/**
	 * Method of modernization.
	 * @param faculty
	 * @return
	 */
	public FacultyDto convert(Faculty faculty) {
		FacultyDto dto = new FacultyDto();

		dto.setId(faculty.getId());
		dto.setNameOfFaculty(faculty.getNameOfFaculty());
		dto.setBudgetSeats(faculty.getBudgetSeats());
		dto.setTotalSeats(faculty.getTotalSeats());

		dto.setEmtpy(new DAOFacultyEnrolleeImpl().isEmptyFaculty(faculty.getId()));
		LOGGER.trace("faculty dto  = "+dto);
		return dto;

	}

}
