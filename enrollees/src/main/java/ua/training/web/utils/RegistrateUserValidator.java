package ua.training.web.utils;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class RegistrateUserValidator {

	
	public static boolean validateUserParameters(String firstName, String lastName,
			String email, String password, String login) {
		return FieldValidation.isFilled(firstName, lastName, login,password) 
				&& (email.contains("@") && !email.isEmpty()) && (password.length() >= 3 &&
				FieldValidation.isCorrectLogin(login)); 
	}
	
	
}
