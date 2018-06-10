package it.uniroma3.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.repository.AttivitaRepository;

@Transactional
@Service
public class AttivitaService {
	
	@Autowired
	    private AttivitaRepository attivitaRepository; 
        
	   public List<Attivita> findAll() {
	       return (List<Attivita>)this.attivitaRepository.findAll();
	    }
	   
	   public Attivita save(Attivita attivita) {
			return this.attivitaRepository.save(attivita);
		}
	   
		public List<Attivita> findByNomeAttivita(String nome) {
			return this.attivitaRepository.findByNomeAttivita(nome);
		}

		public Attivita findByCodice(Long codice) {
			Optional<Attivita> attivita = this.attivitaRepository.findByCodice(codice);
			if (attivita.isPresent()) 
				return attivita.get();
			else
				return null;
		}
		public boolean alreadyExists(Attivita attivita) {
			List<Attivita> attivital = this.attivitaRepository.findByNomeAttivita(attivita.getNomeAttivita());
			if (attivital.size() > 0)
				return true;
			else 
				return false;
		}
}
