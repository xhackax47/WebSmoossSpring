package com.aplose.smooss.controller;

import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Picture;
import com.aplose.smooss.services.EventService;
import com.aplose.smooss.services.PictureService;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@Controller
public class PictureController {
	@Autowired
	private PictureService ps;
	@Autowired
	private EventService es;

//	@RequestMapping(value = "/ProfileController", method = RequestMethod.GET)
	public String showPictures(HttpServletRequest request, HttpServletResponse response) {
		Long eventId = Long.parseLong(request.getParameter("idEvent"));
		Event e = es.read(eventId);
		List<Picture> pictures = ps.findPicturesByEvent(e);

		request.setAttribute("pictures", pictures);
		return "redirect:/WEB-INF/PictureModule.jsp";
	}
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		Part p = request.getPart("file");
//		User author = (User)request.getSession().getAttribute("user");
//		String description = request.getParameter("picture_description");
//		String name = request.getParameter("picture_name");
//		String fileName = StringTools.generateRandomString(12);
//		
//		p.write(fileName);
//		File picture = new File("/tmp/"+fileName);
//		
//		String imgBase64 = ImageTools.encodeImageBase64(picture);
//		Event e = EventService.getInstance().read(2);
//		PictureService.getInstance().create(e,imgBase64, name, description, author);
//		picture.delete();
//		//Long.parseLong(request.getParameter("idEvent"))
//	}
}
