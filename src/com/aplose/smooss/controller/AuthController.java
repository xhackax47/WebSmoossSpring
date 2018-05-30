package com.aplose.smooss.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.Login;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.EmailService;
import com.aplose.smooss.services.UserService;
import com.aplose.smooss.validator.UserValidator;

@Controller
public class AuthController {
	
	@Autowired
	private UserService us;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private EmailService es;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/login")
	public String login(Model model) {
		model.addAttribute("loginForm", new Login());
		
		return "login";
	}
	
	@PostMapping(value="/login")
	public String connectUser(@Valid @ModelAttribute("loginForm")Login login, BindingResult bindingResult, Model model, HttpSession session) throws IOException {
		
		if (bindingResult.hasErrors()) {
			return "login";
		}

		
		User u = us.findByEmailAndPassword(login.getEmail(), login.getPassword());
		
		if ( u != null ) {
			session.setAttribute("user", u);
			return "redirect:home";
		} else {
			model.addAttribute("globalError", "*Mauvais identifiants.");
			return "login";
		}
		
	}

	@PostMapping(value="/logout")
	public String logout() {
		return "index";
	}

	@GetMapping(value = "/registration")
	public String indexPage(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@PostMapping(value="/registration")
	public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model)
			throws EmailException {

		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		us.create(userForm);
		es.sendMail(userForm.getEmail(), "contact@smooss.fr", "Bonjour "+userForm.getFirstName()+" !", "Bienvenue sur Smooss "+userForm.getFirstName()+
				" ! Nous sommes heureux de vous comptez parmis nos membres ! A très vite sur www.smooss.fr");

		//TODO auto login !!!
		return "redirect:home";
	}
	
	
}
