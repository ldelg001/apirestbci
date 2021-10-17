package cl.bci.apirest.exception;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase para manejo de excepciones.
 * @author ldelgado
 *
 */
@ControllerAdvice
public class ApiException {

	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({UserNotEnabledException.class})
	@ResponseBody
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception error)
	{
		return new ErrorMessage(error);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({Exception.class, FormatEmailException.class, PasswordInvalidException.class, RegisteredMailException.class,
		EmailNullException.class, NameNullException.class})
	@ResponseBody
	public ErrorMessage badRequest(Exception error)
	{
		return new ErrorMessage(error);
	}
	
	
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	@ExceptionHandler({ForbiddenException.class, AccessDeniedException.class})
	@ResponseBody
	public ErrorMessage forbiddenRequest(Exception error)
	{
		return new ErrorMessage(error);
	}
}
