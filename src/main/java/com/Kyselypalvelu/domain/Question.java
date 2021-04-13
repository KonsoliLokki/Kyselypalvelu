package com.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
	private String type;
	private String quetext;
	private boolean status;
	private boolean required;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "surveyId", referencedColumnName = "surveyId")
	private Survey survey;

	public Question() {
		super();

	}

	public Question(long questionId, String type, String quetext, boolean status, boolean required) {
		super();
		this.questionId = questionId;
		this.type = type;
		this.quetext = quetext;
		this.status = status;
		this.required = required;
	}

	
	public Question(String type, String quetext, boolean status, boolean required, Survey survey) {

		super();
		this.type = type;
		this.quetext = quetext;
		this.status = status;
		this.required = required;
		this.survey = survey;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setQuetext(String quetext) {
		this.quetext = quetext;
	}

	public String getQuetext() {
		return quetext;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
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
		if (this.survey != null)
			return "Question [questionId=" + questionId + ", type=" + type + ", question=" + quetext + 
					", status=" + status + ", required=" + required + ", survey=" + this.getSurvey() + "]";
		else
			return "Question [questionId=" + questionId + ", type=" + type + ", question=" + quetext + 
					", status=" + status + ", required=" + required + "]";
	}
}
