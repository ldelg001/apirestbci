package cl.bci.apirest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cl.bci.apirest.model.entity.User;

/**
 * Validate: Clase que valida entrada de datos.
 * @author ldelgado
 *
 */
public class Validate {

	private static Pattern patternEmail = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[c|l]{2,})$");
	
	private static Pattern patternPassword = Pattern
            .compile("^[A-Z]{1}([a-z]+)([0-9]{2})$"); 
	
	/**
	 * Valida formato de correo.
	 * @param email
	 * @return true: ok/false:not ok
	 */
	public static boolean valiteEmail(String email)
	{
		boolean result = false;
		
		Matcher mather = patternEmail.matcher(email);
 
        if (mather.find() == true) {
            result = true;
        } 
        
        return result;
	}
	
	/**
	 * Valida formato de clave.
	 * @param password
	 * @return true: ok/false:not ok
	 */
	public static boolean valitePassword(String password)
	{
		boolean result = false;
		
		Matcher mather = patternPassword.matcher(password);
 
        if (mather.find() == true) {
            result = true;
        } 
        
        return result;
	}
	
	
	/**
	 * Establece la clase UserExpone.
	 * @param userAux
	 * @return UserExpone
	 */
	public static UserExpone setUserExpone(User userAux)
	{
		UserExpone userExpone = new UserExpone();
		userExpone.setDatecreated(userAux.getDatecreated());
		userExpone.setDatelast_login(userAux.getDatelast_login());
		userExpone.setDatemodified(userAux.getDatemodified());
		userExpone.setEmail(userAux.getEmail());
		userExpone.setIduser(userAux.getIduser());
		userExpone.setIsactive(userAux.getIsactive());
		userExpone.setName(userAux.getName());
		userExpone.setPassword(userAux.getPassword());
		userExpone.setToken(userAux.getToken());
		
		return userExpone;
	}
}
