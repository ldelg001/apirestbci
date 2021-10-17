package cl.bci.apirest.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bci.apirest.model.entity.User;
import cl.bci.apirest.repository.IUserRepository;


/**
 * UserService: Clase servicio.
 * @author ldelgado
 *
 */
@Service
public class UserService {

	@Autowired
	private IUserRepository repository;
	
	/**
	 * Graba entidad User.
	 * @param entity
	 */
	public User save(User entity)
	{
		try
		{
			User u = repository.save(entity);
			return u;
		}
		catch (Exception error)
		{
			return new User();
		}
	
	}
	
	/**
	 * Actuzliza entidad User.
	 * @param entity
	 * @return true, false
	 */
	public boolean update(User entity)
	{
		try
		{
			repository.save(entity);
			return true;
		}
		catch (Exception error)
		{
			return false;
		}
	}
	
	/**
	 * Elimina entidad.
	 * @param id
	 * @return true, false
	 */
	public boolean detete(UUID id)
	{
		try
		{
			repository.deleteById(id);
			return true;
		}
		catch (Exception error)
		{
			return false;
		}
	}
	
	
	
	/**
	 * Busca la existencia del email en la basew datos.
	 * @param email
	 * @return true: si existe / false: no existe
	 */
	public boolean existeEmailNewUser(String email)
	{
		boolean result = false;
		try
		{
			User u = repository.findByEmail(email);
		
			if (u != null)
			{
				result = true;
			}
		}
		catch (Exception error)
		{
			result = false;
		}
		return result;	
	}
	
	/**
	 * Busca la existencia del email en la base datos, excepto cuando el usuario consulta.
	 * @param email
	 * @return true: si existe / false: no existe
	 */
	public boolean existeEmailUserSave(String email, String name)
	{
		boolean result = false;
		try
		{
			User u = repository.existeEmailUserSave(email, name);
		
			if (u != null)
			{
				result = true;
			}
		}
		catch (Exception error)
		{
			result = false;
		}
		return result;
	}
	
	/**
	 * Busca el usuario por nombre.
	 * @param name
	 * @return
	 */
	public User findUser(String name)
	{
		try
		{
			return repository.findByName(name);
		}
		catch (Exception error)
		{
			return new User();
		}
	}
}
