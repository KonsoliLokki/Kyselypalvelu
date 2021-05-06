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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;

	@ManyToOne
	@JoinColumn(name = "typeId", referencedColumnName = "typeId")
	private QuestionType questiontype;

	private String quetext;
	private boolean status;
	private boolean required;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	@JsonIgnoreProperties({ "type", "quetext", "status", "required", "survey", "questiontype" })
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Choice> choices;

	@ManyToOne
	@JsonIgnoreProperties({ "survey", "name", "status", "questions", "desc", "amount" })
	@JoinColumn(name = "surveyId", referencedColumnName = "surveyId")
	private Survey survey;

	public Question() {
		super();

	}

	public Question(QuestionType questiontype, String quetext, boolean status, boolean required) {
		super();

		this.questiontype = questiontype;
		this.quetext = quetext;

		this.status = status;
		this.required = required;
	}

	public Question(QuestionType questiontype, String quetext, boolean status, boolean required, Survey survey) {

		super();
		this.questiontype = questiontype;
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

	public QuestionType getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(QuestionType questiontype) {
		this.questiontype = questiontype;
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

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	@Override
	public String toString() {
		if (this.survey != null)
			return quetext + "\n";
		else
			return questiontype + " " + quetext;
	}
}