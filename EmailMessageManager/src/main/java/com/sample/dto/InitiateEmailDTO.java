package com.sample.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "EmailData")
public class InitiateEmailDTO {

	@JacksonXmlProperty(localName = "charSequenceId") 
	private Long charSequenceId;
	
	@JacksonXmlElementWrapper(localName = "emailIds")
	@JacksonXmlProperty(localName = "emailId")
	private List<String> emailIds = new ArrayList<>();

	public Long getCharSequenceId() {
		return charSequenceId;
	}

	public void setCharSequenceId(Long charSequenceId) {
		this.charSequenceId = charSequenceId;
	}

	public List<String> getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(List<String> emailIds) {
		this.emailIds = emailIds;
	}

	public InitiateEmailDTO() {
		super();
	}

	public InitiateEmailDTO(Long charSequenceId, List<String> emailIds) {
		this.charSequenceId = charSequenceId;
		this.emailIds = emailIds;
	}

	@Override
	public String toString() {
		return "InitiateEmailDTO [charSequenceId=" + charSequenceId + ", emailIds=" + emailIds + "]";
	}


}
