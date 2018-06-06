package it.uniroma3.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService {
	
	@Autowired
	    private AllievoRepository allievoRepository; 
        
	    public List<Allievo> findAll() {
	       return (List<Allievo>)this.allievoRepository.findAll();
	    }

		public Allievo save(Allievo allievo) {
			return this.allievoRepository.save(allievo);
		}

		public List<Allievo> findByNome(String nome) {
			return this.allievoRepository.findByNome(nome);
		}
		public List<Allievo> findByCogome(String cognome) {
			return this.allievoRepository.findByNome(cognome);
		}

	    public void add(final Allievo allievo) {
	        this.allievoRepository.save(allievo);
	    }

		public Allievo findById(Long id) {
			Optional<Allievo> allievo = this.allievoRepository.findById(id);
			if (allievo.isPresent()) 
				return allievo.get();
			else
				return null;
		}
		public boolean alreadyExists(Allievo allievo) {
			List<Allievo> allievi = this.allievoRepository.findByNomeAndCognomeAndDataDiNascitaAndLuogoDiNascita(allievo.getNome(), allievo.getCognome(), allievo.getDataDiNascita(), allievo.getLuogoDiNascita());
			if (allievi.size() > 0)
				return true;
			else 
				return false;
		}

		public List<Allievo> findByLuogoDiNascita(String luogoDiNascita) {
			return this.allievoRepository.findByLuogoDiNascita(luogoDiNascita);
		}	
	}

