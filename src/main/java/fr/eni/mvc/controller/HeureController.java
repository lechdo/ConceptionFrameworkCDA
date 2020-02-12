package fr.eni.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/heure")
public class HeureController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String formatDate(ModelMap map) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String chaine = sdf.format(new Date());
		map.addAttribute("heureFormate", chaine);
		
		List<String> blabla = new ArrayList<>();
		blabla.add("Anne");
		blabla.add("Lise");
		map.addAttribute("liste", blabla);
		
		return "bonjour";
	}
	

}
