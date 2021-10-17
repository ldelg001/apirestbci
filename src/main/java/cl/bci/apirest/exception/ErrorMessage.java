package cl.bci.apirest.exception;

/**
 * Clase para manejo de mensajes.
 * @author ldelgado
 *
 */
public class ErrorMessage {

	private String message;
	
	public ErrorMessage(Exception error) 
	{
		this(error.getMessage());
	}
	
	public ErrorMessage(String message)
	{
		this.message = message;
		
	}


	public String getMessage() {
		return message;
	}

	
}
