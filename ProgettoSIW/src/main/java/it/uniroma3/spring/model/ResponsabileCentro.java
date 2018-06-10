package it.uniroma3.spring.model;

import javax.persistence.OneToOne;

public class ResponsabileCentro extends Responsabile {

	public ResponsabileCentro(String nome, String cognome) {
		super(nome, cognome);
	}
	
	@OneToOne
	private Centro centro;

}
