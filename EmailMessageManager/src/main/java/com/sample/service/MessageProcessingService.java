package com.sample.service;

import org.springframework.stereotype.Service;

@Service
public interface MessageProcessingService {

	public void retriveAndSendEmail(Long charSequenceId);
}
