package com.aplose.smooss.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Login;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService us;

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
	public String connectUser(@ModelAttribute("loginForm")Login login, Model model, BindingResult bindingresults, HttpSession session) throws IOException {
		
		User u = us.findByEmailAndPassword(login.getEmail(), login.getPassword());

		if (u != null) {
			session.setAttribute("user", u);
//			model.addAttribute("eventForm", new Event());
			return "redirect:home";
		} else {
			return "redirect:login";
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
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model)
			throws EmailException {
//		TODO
//		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		us.create(userForm);
		//TODO auto login !!!
		return "home";
	}
}
