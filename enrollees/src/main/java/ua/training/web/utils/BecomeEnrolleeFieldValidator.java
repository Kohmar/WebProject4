package ua.training.web.utils;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public class BecomeEnrolleeFieldValidator {

	public static boolean isValidCityAndRegion(String city, String region) {
		return (validateCity(city) && validateRegion(region));
	}
	
	
	private static boolean validateCity(String city) {
		if(city == null) {
			return false;
		}
		if(!city.matches("^([a-zA-Zа-яА-Я\u0080-\u024F]+(?:. |-| |'))*[a-zA-Zа-яА-Я\u0080-\u024F]*$")){
			return false;
		}
		return true;
	}


	private static boolean validateRegion(String region) {
		if(region == null) {
			return false;
		}
		if(!region.matches("^([a-zA-Zа-яА-Я\u0080-\u024F]+(?:. |-| |'))*[a-zA-Zа-яА-Я\u0080-\u024F]*$")){
			return false;
		}
		return true;
	}


	
	
}
