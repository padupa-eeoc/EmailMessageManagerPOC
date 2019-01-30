package com.sample.queueconfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.service.MessageProcessingService;

@Component
public class MessageListener {
	
	@Autowired
	MessageProcessingService messageProcessingService;
	
	//@JmsListener(destination = "emaillist", containerFactory = "jmsListenerContainerFactory")
	@RabbitListener(queues = "emaillist")
	public void receiveMessage(Long charSequenceId) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+": Received Message with Unique CharSequenceId:" + charSequenceId+ "--" + Thread.currentThread().getName());
		messageProcessingService.retriveAndSendEmail(charSequenceId);
	}

}
