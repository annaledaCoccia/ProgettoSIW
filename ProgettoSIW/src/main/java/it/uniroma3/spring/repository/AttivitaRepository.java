package it.uniroma3.spring.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.model.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita, Long>

{
	
	public Optional<Attivita> findByCodice(Long codice);
	
	public List<Attivita> findByNomeAttivita(String nomeAttivita);
	
	public List<Attivita> findByData(Date dataAttivita);
}