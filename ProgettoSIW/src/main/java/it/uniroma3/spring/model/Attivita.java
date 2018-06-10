package it.uniroma3.spring.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Attivita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codice;
	
	@NotNull
	private String nomeAttivita;
	
	@NotNull
	private Date data;
	
	//@NotNull
	private Date orarioinizio;
	
	//@NotNull
	private Date orariofine;
	
	@ManyToOne
	private Centro centro;
	
public Attivita() {}
	
	public Attivita(String nome, Date data, Date orarioinizio, Date orariofine) {
		this.nomeAttivita=nome;;
		this.data=data;
		this.orarioinizio=orarioinizio;
		this.orariofine=orariofine;
	}
	
	public Long getCodice() {
		return codice;
	}

	public void setCodice(Long codice) {
		this.codice = codice;
	}

	public String getNomeAttivita() {
		return nomeAttivita;
	}

	public void setNomeAttivita(String nome) {
		this.nomeAttivita = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getOrarioinizio() {
		return orarioinizio;
	}

	public void setOrarioinizio(Date orarioinizio) {
		this.orarioinizio = orarioinizio;
	}

	public Date getOrariofine() {
		return orariofine;
	}

	public void setOrariofine(Date orariofine) {
		this.orariofine = orariofine;
	}

	
}

