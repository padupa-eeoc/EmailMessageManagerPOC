package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.EmailsData;
import com.sample.repository.EmailsRepository;

@Service
public class MessageProcessingServiceImpl implements MessageProcessingService {
	
	@Autowired
	private SendEmailService sendEmailService;
	
	@Autowired
	private EmailsRepository emailRepository;

	@Override
	//@Async
	public void retriveAndSendEmail(Long charSequenceId) {
		
		System.out.println("Fetching in database for emailIds with 'charSequenceId': " + charSequenceId);
		EmailsData emailsData = emailRepository.findOne(charSequenceId);
		
		if (emailsData!=null && emailsData.getEmailIds() != null) {
			emailsData.getEmailIds().stream().forEach(emailId -> {
				System.out.println("Sending Email to e-mailId: " + emailId + "--" + Thread.currentThread().getName());
				sendEmailService.sendEmail(emailId, "noreply@gmail.com", "Email Verification",
						"Click here to verify your email");
			});
		} else {
			System.out.println("No Valid Record found in DB for given 'charSequenceId' " + charSequenceId);
		}
	}

}
