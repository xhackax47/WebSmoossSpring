package com.aplose.smooss.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.TypeModule;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.EventService;
import com.aplose.smooss.tools.ImageTools;
import com.aplose.smooss.tools.StringTools;

@Controller
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class HomeController {

	@Autowired
	private EventService es;
	
	@GetMapping(value = "/home")
	public String home(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		List<Event> events = es.findEventsByUser(user);
		model.addAttribute("events", events);
		model.addAttribute("eventForm", new Event());
		model.addAttribute("listModule", TypeModule.values());
	
		return "home";
	}
	
	@PostMapping(value = "/home")
	public String createEvent(@RequestParam("fileData") MultipartFile file,@ModelAttribute("eventForm") Event eventForm, Model model, HttpSession session) throws IOException, ServletException {
		User admin 		= (User) session.getAttribute("user");	
		Instant start 	= formatDateAndTime(eventForm.getStartDateEvent(), eventForm.getStartTimeEvent());
		Instant end 	= formatDateAndTime(eventForm.getEndDateEvent(), eventForm.getEndTimeEvent());
		eventForm.setAdmin(admin);
		
        if ( start.isBefore(end)) {
            String randomString = StringTools.generateRandomString(12);
        	InputStream inputStream = file.getInputStream();
        	File fileForm = new File(randomString + file.getOriginalFilename());
        	OutputStream outputStream = new FileOutputStream("/tmp/" + fileForm);
        	
        	String pictureBase64 = ImageTools.encodeImageBase64(inputStream, "jpg");

        	eventForm.setPicture(pictureBase64);        	
        	es.create(eventForm);
        	inputStream.close();
        	outputStream.close();
        	fileForm.delete();
        	
            for (String module : eventForm.getListModule()) {
            	System.out.println(module);
                    switch (module) {
                        case "PlaylistModule":
                            es.addModuleByEvent(eventForm, TypeModule.PlaylistModule);
                            break;
                        case "TriCountModule":
                            es.addModuleByEvent(eventForm, TypeModule.TriCountModule);
                            break;
                        case "PicturesModule":
                        	es.addModuleByEvent(eventForm, TypeModule.PicturesModule);
                            break;
                        case "ChatModule":
                            es.addModuleByEvent(eventForm, TypeModule.ChatModule);
                            break;
                        case "MiniGameModule":
                            es.addModuleByEvent(eventForm, TypeModule.MiniGameModule);
                            break;
                        case "CarpoolingModule":
                            es.addModuleByEvent(eventForm, TypeModule.CarpoolingModule);
                            break;
                        case "BringModule":
                            es.addModuleByEvent(eventForm, TypeModule.BringModule);
                            break;
                    }
            }
            
            es.update(eventForm);

            model.addAttribute("event", eventForm);
            
            //TODO => Presque ça ! Ici on ramène tous les modules qui existe dans l'enum
            model.addAttribute("modules", TypeModule.values());
            return "event";
        }  else {	
            String message = "La date de début ne peut pas être inférieure à la date de fin !";
            
			return "home?message=" + URLEncoder.encode(message, "UTF-8");
        }
	}
	
	private Instant formatDateAndTime(String date, String time) {
		StringBuilder sb = new StringBuilder();
		sb.append(date.replace("/", ":"));
		sb.append("T");
		sb.append(time);
		sb.append(":00Z");

		return Instant.parse(sb.toString());
	}
}
