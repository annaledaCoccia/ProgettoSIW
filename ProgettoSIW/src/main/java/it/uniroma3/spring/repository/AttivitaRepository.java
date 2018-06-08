package it.uniroma3.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita, Long>
{
	public List<Attivita> findByNomeAttivita(String nomeAttivita);
	
	public List<Attivita> findByData(Date dataAttivita);
}