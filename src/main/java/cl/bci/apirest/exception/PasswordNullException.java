package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class PasswordNullException  extends Exception{
	

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -886834944545064616L;

	public PasswordNullException() {
		super(IMessages.CLAVE_NO_INGRESADO);
	} 
	
	public PasswordNullException(String detail) {
		super(IMessages.CLAVE_NO_INGRESADO + ". " + detail);
	}

}