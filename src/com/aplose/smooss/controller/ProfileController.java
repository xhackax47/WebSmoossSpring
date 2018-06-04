package com.aplose.smooss.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;
import com.aplose.smooss.tools.ImageTools;
import com.aplose.smooss.tools.StringTools;

@Controller
@Scope("session")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProfileController {

	@Autowired
	private UserService us;

	@GetMapping(value = "/profile")
	public String managementProfil(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");

		model.addAttribute("userProfilForm", user);

		return "profile";
	}

	@PostMapping(value = "/profile")
	public String managementProfil(@RequestParam("fileData") MultipartFile file,
			@ModelAttribute("userProfilForm") User userProfilForm, HttpSession session) throws IOException {

		User user = (User) session.getAttribute("user");

		String randomString = StringTools.generateRandomString(12);
		InputStream inputStream = file.getInputStream();
		File fileForm = new File(randomString + file.getOriginalFilename());
		OutputStream otpStream = new FileOutputStream("/tmp/" + fileForm);

		String pictureBase64 = ImageTools.encodeImageBase64(inputStream, "jpg");
		userProfilForm.setPicture(pictureBase64);
		userProfilForm.setId(user.getId());
		us.update(userProfilForm);
		inputStream.close();
		otpStream.close();
		fileForm.delete();

		session.setAttribute("user", userProfilForm);
		return "profile";

	}
}

