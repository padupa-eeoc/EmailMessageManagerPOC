package com.sample.service;

import org.springframework.stereotype.Service;

import com.sample.dto.InitiateEmailDTO;

@Service
public interface EmailsProcessService {

	public void insertAndQueue(InitiateEmailDTO initiateEmailDTO);
}
