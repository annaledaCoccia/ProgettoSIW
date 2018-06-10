package it.uniroma3.spring.model;

import javax.persistence.OneToOne;

public class ResponsabileAzienda extends Responsabile {

	public ResponsabileAzienda(String nome, String cognome) {
		super(nome, cognome);
	}
	
	@OneToOne
	private Azienda azienda;
}
