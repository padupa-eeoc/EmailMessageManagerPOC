package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService {
	 
	@Autowired
    private JavaMailSender emailSender;

	@Override
	public void sendEmail(String to, String from, String subject, String body) {
		SimpleMailMessage emailMessage = new SimpleMailMessage(); 
        emailMessage.setTo(to); 
        emailMessage.setFrom(from);
        emailMessage.setSubject(subject); 
        emailMessage.setText(body);
        emailSender.send(emailMessage);	
	}

}
