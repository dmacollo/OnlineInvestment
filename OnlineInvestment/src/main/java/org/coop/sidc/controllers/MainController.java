package org.coop.sidc.controllers;


import org.coop.sidc.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping(value={"/home"},method=RequestMethod.GET)
	public String welcomePage(Model model){
		return "home";
	}	

	@RequestMapping(method=RequestMethod.GET)
	public String pageNotFound(){
		return "forward:/";
	}
}
