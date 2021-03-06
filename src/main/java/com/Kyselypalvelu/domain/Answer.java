package com.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) long answerId;
	private String ansText;
	
	@ManyToOne
	@JsonIgnoreProperties({"type", "quetext", "status", "required", "survey", "questiontype", "choices"})
	@JoinColumn(name = "questionId", referencedColumnName = "questionId")
	private Question question;
	
	public Answer() {
		super();
	}
	
	public Answer(String ansText, Question question) {
		super();
		this.ansText = ansText;
		this.question = question;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getAnsText() {
		return ansText;
	}

	public void setAnsText(String ansText) {
		this.ansText = ansText;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", ansText=" + ansText + ", question=" + question + "]";
	}
}
