package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> 
{
	public List<Centro> findByNomeCentro(String nomeCentro);
	
	public List<Centro> findByTelefono(String telefonoCentro);
	
	public List<Centro> findByNomeCentroAndEmail(String nomeCentro, String emailCentro);
	
}