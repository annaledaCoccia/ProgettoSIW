package it.uniroma3.spring.model;

import java.util.List;
import it.uniroma3.spring.model.Attivita;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Centro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codice;
	
	@NotNull
	private String nomeCentro;
	
	@NotNull
	private String indirizzo;
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefono;
	
	@NotNull
	private Integer capienza;
	
	@OneToOne
	private Responsabile responsabile;
	
	@OneToMany(mappedBy = "centro")
	private List<Attivita> attivitadisponibili;
	
	public Centro() {
		
	}
	
	public List<Attivita> getAttivitadisponibili() {
		return attivitadisponibili;
	}

	public void setAttivitadisponibili(List<Attivita> attivitadisponibili) {
		this.attivitadisponibili = attivitadisponibili;
	}

	public Centro(String nome, String indirizzo, String email, String telefono, Integer capienza, Responsabile responsabile) {
		this.nomeCentro = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
		this.capienza = capienza;
		this.responsabile = responsabile;
	}

	public Long getCodice() {
		return codice;
	}

	public void setCodice(Long codice) {
		this.codice = codice;
	}

	public String getNomeCentro() {
		return nomeCentro;
	}

	public void setNomeCentro(String nome) {
		this.nomeCentro = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}


	
	

}
