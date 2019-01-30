package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.InitiateEmailDTO;
import com.sample.service.EmailsProcessService;

@RestController
@RequestMapping("/process")
public class EmailProcessingController {
	
	@Autowired
	EmailsProcessService processEmailsService;
	
	
   /**
    * Receives XML/JSON input
    *  -> Saves to DB
    *  -> Sends to queue
    */
	@PostMapping(value="/email", consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE} )
	public void processEmails(@RequestBody InitiateEmailDTO initiateEmailDTO) {
		System.out.println("~~~~~Step:1 - Request Received "+initiateEmailDTO.toString()+"~~~~~");
		processEmailsService.insertAndQueue(initiateEmailDTO);
	}
}
