package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.controller.validator.AttivitaValidator;
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.service.AttivitaService;

@Controller
public class AttivitaController {
	
    @Autowired
    private AttivitaService attivitaService;

    @Autowired
    private AttivitaValidator validator;

    @RequestMapping("/attivital")
    public String attivital(Model model) {
        model.addAttribute("attivital", this.attivitaService.findAll());
        return "attivitaList";
    }

    @RequestMapping("/addAttivita")
    public String addAttivita(Model model) {
        model.addAttribute("attivita", new Attivita());
        return "attivitaForm";
    }
    
    @RequestMapping(value = "/attivita/{codice}", method = RequestMethod.GET)
    public String getAttivita(@PathVariable("codice") Long codice, Model model) {
        model.addAttribute("attivita", this.attivitaService.findByCodice(codice));
    	return "showAttivita";
    }
    
    @RequestMapping(value = "/attivita", method = RequestMethod.POST)
    public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(attivita, bindingResult);
        
        if (this.attivitaService.alreadyExists(attivita)) {
            model.addAttribute("exists", "Questa attivita e' gia registrata");
            return "attivitaForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.attivitaService.save(attivita);
                model.addAttribute("attivital", this.attivitaService.findAll());
                return "attivitaList";
            }
        }
        return "attivitaForm";
    }

}