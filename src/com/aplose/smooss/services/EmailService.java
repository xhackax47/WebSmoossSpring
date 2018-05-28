//package com.aplose.smooss.services;
//
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class EmailService {
//	private static EmailService instance;
//
//	private static String senderEmail = "contact@smooss.fr";
//	private static String password = "sB9_pF9Xc$";
//	private static String mailServer = "mail11.lwspanel.com";
//	private static String smtpPort = "587";
//	private static String sslPort = "993";
//
//	private EmailService() {
//
//	}
//
//	public static EmailService getInstance() {
//		if (instance == null) {
//			instance = new EmailService();
//		}
//		return instance;
//	}
//
//	public static void sendEmail(String receiverEmail, String senderEmail, String subject, String body) {
//		System.out.println("envoi d'un email à : " + receiverEmail);
//		System.out.println("par : " + senderEmail);
//		System.out.println("subject : " + subject);
//		System.out.println("body : " + body);
//
//		Properties properties = System.getProperties();
//		properties.setProperty("mail.smtp.host", mailServer);
//		properties.setProperty("mail.smtp.auth", "true");
//		properties.setProperty("mail.smtp.port", smtpPort);
//		properties.setProperty("mail.smtp.user", senderEmail);
//		properties.setProperty("mail.smtp.starttls.enable", "true");
//		properties.setProperty("mail.smtp.ssl.trust", mailServer);
//
//		Session mailSession = Session.getDefaultInstance(properties);
//
//		try {
//			Message message = new MimeMessage(mailSession);
//			message.setFrom(new InternetAddress(senderEmail));
//
//			InternetAddress to[] = new InternetAddress[1];
//			to[0] = new InternetAddress(receiverEmail);
//			message.setRecipients(Message.RecipientType.TO, to);
//			message.setSubject(subject);
//			message.setContent(body, "text/plain");
//			Transport tr = mailSession.getTransport("smtp");
//			tr.connect(senderEmail, password);
//			tr.sendMessage(message, message.getAllRecipients());
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
