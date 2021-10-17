package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class EmailNullException extends Exception{
	
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 2774508866453804448L;

	public EmailNullException() {
		super(IMessages.CORREO_NO_INGRESADO);
	} 
	
	public EmailNullException(String detail) {
		super(IMessages.CORREO_NO_INGRESADO);
	}

}
