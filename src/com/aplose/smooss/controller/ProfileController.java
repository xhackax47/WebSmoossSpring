package com.aplose.smooss.controller;

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
	public String managementProfil(Model model) {
		model.addAttribute("userProfilForm", new User());

		return "profile";
	}
	
	@PostMapping(value="/profile")
	public String managementProfil(@ModelAttribute("userProfilForm") User userProfilForm, BindingResult bindingResult, Model model) {
//		String extension = null;
//		Part part = request.getPart("file");
//		String fileName = StringTools.generateRandomString(12);
//		part.write(fileName);	
//		File picture = new File("/tmp/"+fileName);
//		extension = ImageTools.getFileFormat(picture);
//		userProfilForm.setPicture(ImageTools.encodeImageBase64(picture, extension));
//		
		us.update(userProfilForm);
		return "profile";
	}

}
