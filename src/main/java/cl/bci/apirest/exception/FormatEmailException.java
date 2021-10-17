package cl.bci.apirest.exception;

import cl.bci.apirest.util.IMessages;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
public class FormatEmailException extends Exception{
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -5409229358697713474L;

	public FormatEmailException() {
		super(IMessages.CORREO_INVALIDO);
	} 
	
	public FormatEmailException(String detail) {
		super(IMessages.CORREO_INVALIDO + ". " + detail);
	}

}
