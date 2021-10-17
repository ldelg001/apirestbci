package cl.bci.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bci.apirest.model.entity.Phones;
import cl.bci.apirest.repository.IPhonesRepository;

@Service
public class PhonesService {
	
	@Autowired
	private IPhonesRepository repository;
	
	/**
	 * Grava entidad Phones.
	 * @param entity
	 */
	public void save(Phones entity)
	{
		repository.save(entity);
	}
	
	
	/**
	 * Elimina entidad.
	 * @param id
	 */
	public void detete(Long id)
	{
		repository.deleteById(id);
	}
	
	/**
	 * Elimina todas las entidad.
	 * @param id
	 */
	public void deteteAll()
	{
		repository.deleteAll();
	}
	
	/**
	 * Obtiene todo los Telefons.
	 * @return Lista de Telefons.
	 */
	public List<Phones> findAll()
	{
		return repository.findAll();
	}
	
	

}
