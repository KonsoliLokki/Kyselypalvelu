package com.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Choice {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) long choiceId;
	private String choiceText;
	
	@ManyToOne
	@JsonIgnoreProperties({"type", "quetext", "status", "required", "survey"})
	@JoinColumn(name = "questionId", referencedColumnName = "questionId")
	private Question question;
	
	public Choice() {
		super();
	}
	
	public Choice(String choiceText, Question question) {
		super();
		this.choiceText = choiceText;
		this.question = question;
	}

	public long getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(long choiceId) {
		this.choiceId = choiceId;
	}

	public String getChoiceText() {
		return choiceText;
	}

	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
}
