package it.uniroma3.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long > {
	    
	public List<Allievo> findByNome(String nome);

    public  List<Allievo> findByCognome(String cognome);
    
    public List<Allievo> findByNomeAndCognomeAndDataDiNascitaAndLuogoDiNascita(
    		String nome, String Cognome, Date dataDiNascita, String luogoDiNascita);

	public List<Allievo> findByLuogoDiNascita(String luogoDiNascita);
}
