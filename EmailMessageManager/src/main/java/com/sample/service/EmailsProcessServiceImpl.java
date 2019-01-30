package com.sample.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dto.InitiateEmailDTO;
import com.sample.entity.EmailsData;
import com.sample.repository.EmailsRepository;

@Service
public class EmailsProcessServiceImpl  implements EmailsProcessService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private EmailsRepository emailsRepository;

	@Override
	public void insertAndQueue(InitiateEmailDTO initiateEmailDTO) {
		EmailsData emailsData = new EmailsData(initiateEmailDTO.getCharSequenceId(), initiateEmailDTO.getEmailIds());
		System.out.println("~~~~~Step:2 - Inserting 'EmailsData' to DB~~~~~~~");
		emailsRepository.save(emailsData);
		
		System.out.println("~~~~~Step:3 - Pushing Unique Id: "+initiateEmailDTO.getCharSequenceId()+" to QUEUE~~~~~");
		
		rabbitTemplate.convertAndSend("emaillist", initiateEmailDTO.getCharSequenceId());
		
	}
	
}
