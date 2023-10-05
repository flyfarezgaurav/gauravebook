package com.travel.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;	
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import com.travel.object.email.EmailFormat;

@Service
public class MailController 
{
	public String SendMail(EmailFormat emailFormat,String host,String mailport,String pass) throws IOException, URISyntaxException {
		String status="false";
		try 
		{
			Map<String,String> emailId=new HashMap<String,String>();

			//	Client emails=clientRepo.findByClientEmail(emailFormat.getFromEmail().trim()).get();
			emailId.put(emailFormat.getFromEmail().trim(),pass.trim());
			Properties props = new Properties();

			if(host.equalsIgnoreCase("smtp.gmail.com")) {

				props.put("mail.smtp.host", host);
				props.put("mail.smtp.socketFactory.port", mailport);
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465"); 
			
			}else {
				
				String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
				props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
				props.setProperty("mail.smtp.socketFactory.fallback", "false");
				props.setProperty("mail.smtp.port", "465");
				props.setProperty("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.debug", "true");
				props.put("mail.store.protocol", "pop3");
				props.put("mail.transport.protocol", "smtp");
				props.put("mail.debug.auth", "true");
				props.setProperty( "mail.pop3.socketFactory.fallback", "false");
				props.put("mail.smtp.host", host);

				/*props.put("mail.transport.protocol", "smtp");
						props.put("mail.smtp.host", host);
						props.put("mail.smtp.port", mailport);

						props.put("mail.smtp.auth", "true");
						if( mailport.equals("587") ) {
							props.put("mail.smtp.starttls.enable", "true");
						} else {
							props.put("mail.smtps.ssl.enable", "true");
						}
						props.put("mail.smtp.ssl.trust",host);
						props.put("mail.smtp.socketFactory", "javax.net.ssl.SSLSocketFactory");
						props.put("mail.smtp.socketFactory.port", mailport);
						props.put("mail.smtp.socketFactory.fallback", "false");
						props.put("mail.smtp.debug", "true");
						props.put("mail.smtp.quitwait", "false");
						MailSSLSocketFactory sf = new MailSSLSocketFactory();
						sf.setTrustAllHosts(true); 
						props.put("mail.imap.ssl.trust", "*");
						props.put("mail.imap.ssl.socketFactory", sf);*/
			}

			try 
			{
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailFormat.getFromEmail(), emailId.get(emailFormat.getFromEmail()));
					}
				});

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(emailFormat.getFromEmail()));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailFormat.getToEmail()));
				message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(emailFormat.getCcEmail()));
				message.setSubject(emailFormat.getMailSubject());
				message.setContent(emailFormat.getMailBody(), "text/html");
				Transport.send(message);

				try 
				{
					System.out.println("Mail Sent from:"+emailFormat.getFromEmail()+" to id:"+emailFormat.getToEmail());
				} catch (Exception e) {

				}
				status="true";
			} catch (Exception e) {
				e.printStackTrace();
				status="false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}


}
