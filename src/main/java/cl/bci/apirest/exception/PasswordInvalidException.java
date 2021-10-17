package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class PasswordInvalidException  extends Exception{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 6228739660898544854L;

	public PasswordInvalidException() {
		super(IMessages.CLAVE_INVALIDO);
	} 
	
	public PasswordInvalidException(String detail) {
		super(IMessages.CLAVE_INVALIDO + ". " + detail);
	}

}