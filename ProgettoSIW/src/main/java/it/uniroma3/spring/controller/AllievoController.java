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


import it.uniroma3.spring.controller.validator.AllievoValidator;
import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.service.AllievoService;

@Controller
public class AllievoController {
	
    @Autowired
    private AllievoService allievoService;

    @Autowired
    private AllievoValidator validator;

    @RequestMapping("/allievi")
    public String customers(Model model) {
        model.addAttribute("allievi", this.allievoService.findAll());
        return "allievoList";
    }

    @RequestMapping("/addAllievo")
    public String addCustomer(Model model) {
        model.addAttribute("allievo", new Allievo());
        return "allievoForm";
    }

    @RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
    public String getCustomer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("allievo", this.allievoService.findById(id));
    	return "showAllievo";
    }

    @RequestMapping(value = "/allievo", method = RequestMethod.POST)
    public String newCustomer(@Valid @ModelAttribute("allievo") Allievo allievo, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(allievo, bindingResult);
        
        if (this.allievoService.alreadyExists(allievo)) {
            model.addAttribute("exists", "Customer already exists");
            return "allievoForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.allievoService.save(allievo);
                model.addAttribute("allievi", this.allievoService.findAll());
                return "allievoList";
            }
        }
        return "allievoForm";
    }

}
