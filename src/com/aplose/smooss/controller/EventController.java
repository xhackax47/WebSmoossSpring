package com.aplose.smooss.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.EventService;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@Controller
public class EventController {
	
	@Autowired
	private EventService es;
	
	@GetMapping(value = "/EventController")
	public String showEventList(HttpServletRequest request, HttpServletResponse response, Model model) {
//		model.addAttribute("event", new Event());
		//TODO verify if / else ?! 
		
		String id = request.getParameter("idEvent");
		if (id != null) {
			Event evt = es.read(Long.parseLong(id));
			request.setAttribute("event", evt);
		} 
		return "event";
	}
	
	@RequestMapping(value= "/DeleteEvent", method = RequestMethod.POST) 
	public String deleteEvent(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("idEvent");
		Event evt = es.read(Long.parseLong(id));
		es.delete(evt);
		
		return "redirect:/EventController";
	}

	@RequestMapping(value="/ModifyEvent", method = RequestMethod.POST)
	public String modifyEvent(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("idEvent");
		Event evt = es.read(Long.parseLong(id));
		es.modify(evt);
		
		return "redirect:/EventController";
	}
	
	

}
