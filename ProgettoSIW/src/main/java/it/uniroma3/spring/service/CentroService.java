package it.uniroma3.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.repository.CentroRepository;

@Transactional
@Service
public class CentroService {

	@Autowired
	private CentroRepository centroRepository;
	
	public Centro save(Centro centro) {
		return this.centroRepository.save(centro);
	}
	
	public List<Centro> findByNomeCentro(String nomeCentro)	{
		return this.centroRepository.findByNomeCentro(nomeCentro);
	}
	
	public List<Centro> findAll() {
		return (List<Centro>) this.centroRepository.findAll();
	}
	
	public Centro findById(Long id) {
		Optional<Centro> centro = this.centroRepository.findById(id);
		if (centro.isPresent()) 
			return centro.get();
		else
			return null;
	}

	public boolean alreadyExists(Centro centro) {
		List<Centro> centri = this.centroRepository.findByNomeCentroAndEmail(centro.getNomeCentro(),centro.getEmail());
		if (centri.size() > 0)
			return true;
		else 
			return false;
	}	
}