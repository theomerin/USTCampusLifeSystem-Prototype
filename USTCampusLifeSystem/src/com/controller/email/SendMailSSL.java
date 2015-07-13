package com.controller.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {

	private String sender;
	private String pass;
	private String recipient;
	private String subject;
	private String message;
	
	public String getSender() {
		return sender;
	}
	private void setSender() {
		this.sender = "ustcampusfeast.system@gmail.com";
	}
	public String getPass() {
		return pass;
	}
	public void setPass() {
		this.pass = "Godwillmakeaway";
	}
	public String getRecipient() {
		return recipient;
	}
	private void setRecipient() {
		this.recipient = "ustcampusfeast.intercessory@gmail.com";
	}
	public String getSubject() {
		return subject;
	}
	private void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	private void setMessage(String message) {
		this.message = message;
	}
	
	public boolean sendMail(String subject, String message) {
		setSender();
		setRecipient();
		setPass();
		setSubject(subject);
		setMessage(message);
		boolean isSent = false;
		
		Properties props = new Properties();  
		props.put("mail.smtp.host", "smtp.gmail.com");  
		props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", "465");  
		   
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {  
		    		protected PasswordAuthentication getPasswordAuthentication() {  
		    			return new PasswordAuthentication(getSender(), getPass());
		    		}  
				});  
		   
		try {  
			
		   MimeMessage emailMessage = new MimeMessage(session);  
		   emailMessage.setFrom(new InternetAddress(getSender()));
		   emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(getRecipient()));  
		   emailMessage.setSubject(getSubject());  
		   emailMessage.setText(getMessage());  
		     
		//send message  
		Transport.send(emailMessage);  
		  
		System.out.println("message sent successfully");  
		isSent = true;
		   
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}  
		   
		return isSent;
	}
}
