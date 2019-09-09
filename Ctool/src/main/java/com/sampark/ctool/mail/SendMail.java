package com.sampark.ctool.mail;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void send(String to,String template,String subject){
		Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		   Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {  
	 
			   protected PasswordAuthentication getPasswordAuthentication(){
				   return new PasswordAuthentication("samparksoftwares2018@gmail.com", "sspl@2018");		   
			   }	   
		  }); 	   
		 try { 
			 
			MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("samparksoftwares2018@gmail.com"));
		   message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));  
		   message.setSubject(subject);  

		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setContent(template,"text/html");
			
		    BodyPart messageBodyPart2 = new MimeBodyPart();  
		    messageBodyPart2.setText("Campaign Name:"+subject);

		    
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		   
		    message.setContent(multipart);   
		   Transport.send(message);  
		   System.out.println("Successfully"); 
		  }
		  catch (MessagingException e){ 
			  e.printStackTrace();
		      throw new RuntimeException(e);
		      
		  }   
		 }	
	
	
	
	
	
	public static void main(String[] args) {
		
		SendMail.send("ankit25496.kumar@gmail.com,rajat.rmehra94@gmail.com,rajatmehra1054@gmail.com,pankaj.negi505@gmail.com","<a href='#'><h3 style='background-color:blue; color:white; padding:25px; text-align:center;'> Click Here For Account Validation</h3></a>", "subject");
		
	}
}
