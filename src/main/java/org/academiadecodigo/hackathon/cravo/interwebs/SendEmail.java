package org.academiadecodigo.hackathon.cravo.interwebs;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
	
	public void main() {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("cravo.hackathon@gmail.com", "cravo1234");
					}
				});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cravo.hackathon@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("martelo300@hotmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
									"\n\n No spam to my email, please!");
			
			Transport.send(message);
			
			System.out.println("Done");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
