package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class RegisteredMailException extends Exception{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -4413900403782790316L;

	public RegisteredMailException() {
		super(IMessages.CORREO_REGISTRADO);
	} 
	
	public RegisteredMailException(String detail) {
		super(IMessages.CORREO_REGISTRADO + ". " + detail);
	}

}
