package ua.training.web.command;

import org.apache.log4j.Logger;
import ua.training.dao.impl.*;
import ua.training.entity.Faculty;
import ua.training.entity.FacultyEnrollee;
import ua.training.entity.FinalReportSheet;
import ua.training.web.ActionType;
import ua.training.web.Path;
import ua.training.web.utils.writeFile.WriteFileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by user on 25.01.2017.
 */
public class MakeResultOnFacultyCommand extends Command {
    /**
     *
     */
    private static final long serialVersionUID = -8514019356292877140L;

    private static final Logger LOG = Logger.getLogger(MakeResultOnFacultyCommand.class);


    private static final Comparator<FacultyEnrollee> SORT_FACULTYENROLLEE_BY_POINTS = new Comparator<FacultyEnrollee>() {

        @Override
        public int compare(FacultyEnrollee o1, FacultyEnrollee o2) {
            return o2.getsummaryPoints() - o1.getsummaryPoints();
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
                          HttpServletResponse response) throws IOException {
        LOG.trace("starting making result...");
        if(new DAOFactoryImpl().getDAOFacultyEnrollee().isEmptyFaculty(Integer.parseInt(request.getParameter("facultyId")))){
            return Path.REDIRECT_TO_VIEW_ALL_USERS;
        }

        List<FacultyEnrollee> list = new DAOFacultyEnrolleeImpl().getAllFacultyEnrollee();
        List<FacultyEnrollee> listOfBudgetEnrollees = new ArrayList<FacultyEnrollee>();
        List<FacultyEnrollee> listOfContractEnrollees = new ArrayList<FacultyEnrollee>();
        List<FacultyEnrollee> listOfNotBlockedEnrollees = new ArrayList<FacultyEnrollee>();
        List<FinalReportSheet> finalReportSheets = new ArrayList<FinalReportSheet>();
        List<FacultyEnrollee> listOfNotBudgetNotContract = new ArrayList<FacultyEnrollee>();
        LOG.trace("FacultyEnrollees were got" + list);
//		Collections.sort(list,SORT_FACULTYENROLLEE_BY_POINTS);
        LOG.trace("faculties were sorted : " + Arrays.asList(list));
        Integer budgetSeats = new FacultyDAOImpl().getNumberOfBudgetSeats(Integer.parseInt(request.getParameter("facultyId")));
        Faculty faculty = new FacultyDAOImpl().getFacultyById(Integer.parseInt(request.getParameter("facultyId")));
        for(FacultyEnrollee item : list) {
//			Enrollee enrollee = new EnrolleeDAOImpl().getEnrolleeById(item.getEnrolleeId());
            boolean status = new EnrolleeDAOImpl().getStatusOfEnrollee(item.getEnrolleeId());
            if(status == false) {
                listOfNotBlockedEnrollees.add(item);
            } else {
//				continue label;
            }
        }

        Collections.sort(listOfNotBlockedEnrollees, SORT_FACULTYENROLLEE_BY_POINTS);
        for(FacultyEnrollee item : listOfNotBlockedEnrollees) {
            if(list.indexOf(item) <= budgetSeats - 1) {
                listOfBudgetEnrollees.add(item);
            } else if((list.indexOf(item) > budgetSeats - 1) && (list.indexOf(item) <= faculty.getTotalSeats() - 1)) {
                listOfContractEnrollees.add(item);
            } else if(list.indexOf(item) > faculty.getTotalSeats() - 1){
                listOfNotBudgetNotContract.add(item);
            }
        }



        try {
            WriteFileUtils.wtireToFileResultsOfBudget(listOfBudgetEnrollees);
            WriteFileUtils.wtireToFileResultsOfContract(listOfContractEnrollees);
            WriteFileUtils.wtireToFileResultsOfNotBudgetNotContract(listOfNotBudgetNotContract);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        request.getSession().setAttribute("finalResult", finalReportSheets);

        return Path.REDIRECT_TO_VIEW_ALL_FACULTIES;
    }


}
