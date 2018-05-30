package com.aplose.smooss.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendMail(String receiverEmail,String contact, String subject, String body) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setFrom(contact);
			helper.setTo(receiverEmail);
			helper.setText(body);
			helper.setSubject(subject);
			this.javaMailSender.send(message);
		} catch (MessagingException me) {
			// simply log it and go on...
			System.err.println(me.getMessage());
		}
	}
}
