package com.sample.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMAIL_LIST")
public class EmailsData {

	@Id
	private Long charSequenceId;

	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "EMAIL_IDS")
	@Column(name = "EMAIL_ID") 
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

	public EmailsData() {
		super();
	}

	public EmailsData(Long charSequenceId, List<String> emailIds) {
		this.charSequenceId = charSequenceId;
		this.emailIds = emailIds;
	}

}
