package org.academiadecodigo.hackathon.cravo.interwebs;

import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.utils.Messages;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
	
	private UserServiceImpl userService;
	private Session session;
	private MimeMessage message;
	
	public SendEmail(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	public void load() {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("cravo.hackathon@gmail.com", "cravo1234");
					}
				});
		
		try {
			
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cravo.hackathon@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userService.get(1).getEmail()));
			message.setSubject("Testing Subject");
			
			System.out.println("Done");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void register(Integer id) {
		load();
		try {
			message.setText(Messages.mailNeed(userService.get(id).getName()));
			
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void offer(Integer id) {
		load();
		try {
			message.setText(Messages.mailOffer(userService.get(id).getName()));
			
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void need(Integer id) {
		load();
		try {
			message.setText(Messages.mailOffer(userService.get(id).getName()));
			
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
