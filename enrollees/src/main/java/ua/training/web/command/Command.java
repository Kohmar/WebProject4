package ua.training.web.command;


import ua.training.web.ActionType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public abstract class Command implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8232986207034616233L;

	
	
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException;
	
	
	@Override
	public final String toString() {
		return getClass().getSimpleName();
	}
	
}
