package com.aplose.smooss.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.EventService;

@Controller
public class HomeController {

	@Autowired
	private EventService es;
	
	@GetMapping(value = "/home")
	public String home(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		List<Event> events = es.findEventsByUser(user);
		model.addAttribute("events", events);
		model.addAttribute("eventForm", new Event());
	
		return "home";
	}
	
	@PostMapping(value = "/home")
	public String createEvent(@ModelAttribute("eventForm") Event eventForm, Model model, HttpSession session) throws IOException, ServletException {
		User admin = (User) session.getAttribute("user");
		
		Instant start = formatDateAndTime(eventForm.getStartDateEvent(), eventForm.getStartTimeEvent());
		Instant end = formatDateAndTime(eventForm.getEndDateEvent(), eventForm.getEndTimeEvent());

        if ( start.isBefore(end)) {
//            String fileName = StringTools.generateRandomString(12);
//            Part p = eventForm.getPicture();
//            p.write(fileName);
//            File picture = new File("/tmp/" + fileName);
//
//            String pictureBase64 = ImageTools.encodeImageBase64(picture, "jpg");
        	//TODO => The Event is Created but not linked with a user ID..
           es.create(eventForm);
    
//            String[] parameters = new String[] { "PlaylistModule", "TriCountModule", "PicturesModule", "ChatModule",
//                    "MiniGameModule", "CarpoolingModule", "BringModule" };
//
//            for (String parameter : parameters) {
//                String checkBoxValue = request.getParameter(parameter);
//                if (checkBoxValue != null) {
//                    switch (parameter) {
//                        case "PlaylistModule":
//                            es.addModuleByEvent(evt, TypeModule.PlaylistModule);
//                            break;
//                        case "TriCountModule":
//                            es.addModuleByEvent(evt, TypeModule.TriCountModule);
//                            break;
//                        case "PicturesModule":
//                        	es.addModuleByEvent(evt, TypeModule.PicturesModule);
//                            break;
//                        case "ChatModule":
//                            es.addModuleByEvent(evt, TypeModule.ChatModule);
//                            break;
//                        case "MiniGameModule":
//                            es.addModuleByEvent(evt, TypeModule.MiniGameModule);
//                            break;
//                        case "CarpoolingModule":
//                            es.addModuleByEvent(evt, TypeModule.CarpoolingModule);
//                            break;
//                        case "BringModule":
//                            es.addModuleByEvent(evt, TypeModule.BringModule);
//                            break;
//                    }
//                }
//            }

            model.addAttribute("event", eventForm);
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
