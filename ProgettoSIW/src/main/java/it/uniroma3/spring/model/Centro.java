package it.uniroma3.spring.model;

import javax.persistence.*;

@Entity
public class Centro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String indirizzo;
	
	@Column(nullable = false)
	private String capienzaMax;
	
	@Column(nullable = false)
	private String mail;

}
