package com.aplose.smooss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService us;


	@GetMapping(value="/profile")
	public String managementProfil(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("userProfilForm", user);

		return "profile";
	}
	
	@PostMapping(value="/profile")
	public String managementProfil(@ModelAttribute("userProfilForm") User userProfilForm, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		userProfilForm.setId(user.getId());
		us.update(userProfilForm);
		
		session.setAttribute("user", userProfilForm);
		return "redirect:profile";
		
	}

}
