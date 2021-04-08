package com.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String type;
	private String answer;
	private boolean status;
	private boolean required;
	
	@ManyToOne
	@JsonIgnoreProperties ("questions")
	@JoinColumn(name = "surveyId", referencedColumnName = "surveyId")
	private Survey survey;

	public Question() {
		super();
		
	}
	
	public Question(String type, String answer, boolean status, boolean required, Survey survey) {
		super();
		this.type = type;
		this.answer = answer;
		this.status = status;
		this.required = required;
		this.survey = survey;
	}

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public boolean isRequired() {
		return required;
	}



	public void setRequired(boolean required) {
		this.required = required;
	}



	public Survey getSurvey() {
		return survey;
	}



	public void setSurvey(Survey survey) {
		this.survey = survey;
	}



	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", answer=" + answer + ", status=" + status + ", required="
				+ required + ", survey=" + survey + "]";
	}
}
