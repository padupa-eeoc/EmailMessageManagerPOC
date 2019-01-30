package com.sample.service;

import org.springframework.stereotype.Service;

@Service
public interface SendEmailService {

	public void sendEmail(String to, String from, String subject, String body);
}
