package fr.eni.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hello", "msg", "Coucou");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/bonjour")
	public ModelAndView bonjour(String nom) {
		ModelAndView mav = new ModelAndView("hello", "msg", "Bonjour" + nom + "!");
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/ajout")
	public ModelAndView ajout(String nom, String prenom) {
		ModelAndView mav = new ModelAndView("hello", "msg",
				"La personne (" + prenom + " " + nom + ") a bien été ajoutée");

		return mav;

	}
}
