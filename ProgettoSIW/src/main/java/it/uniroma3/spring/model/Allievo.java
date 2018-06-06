package it.uniroma3.spring.model;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="allievo")
public class Allievo {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(nullable=false)
    private String nome;

	@Column(nullable=false)
    private String cognome;

	@Column(nullable=false)
    private Date dataDiNascita;
	
	@Column(nullable=false)
    private String luogoDiNascita;
	
	@Column(nullable=true)
    private String telefono;
	
	@Column(nullable=true)
    private String email;

	public Allievo() {}
	
	public Allievo(String nome, String cognome, Date dataDiNascita,String luogoDiNascita, String telefono, String email) {
		this.nome=nome;
		this.cognome=cognome;
		this.dataDiNascita=dataDiNascita;
		this.luogoDiNascita=luogoDiNascita;
		this.telefono=telefono;
		this.email=email;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Allievo [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", luogoDiNascita=" + luogoDiNascita + ", telefono=" + telefono + ", email=" + email + "]";
	}
	
}
