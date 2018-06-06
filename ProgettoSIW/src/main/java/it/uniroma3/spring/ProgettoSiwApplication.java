package it.uniroma3.spring;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.service.AllievoService;

@SpringBootApplication
public class ProgettoSiwApplication {
	@Autowired
	private AllievoService allievoService; 
	
	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiwApplication.class, args);
	}
	@PostConstruct
	public void init() {
		Date date= new Date(2013/02/13);
		Allievo allievo = new Allievo("Paolo", "Merialdo", date, "Genova","0686322806","paoloMerialdo@gmail.it");
		allievoService.save(allievo);
		for(Allievo c : allievoService.findByLuogoDiNascita("Genova")) {
			System.out.println(c.getNome());
		}
	}
}
