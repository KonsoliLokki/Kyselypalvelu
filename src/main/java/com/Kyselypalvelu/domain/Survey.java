package com.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Survey {

	// long id, string name, int amount, status bool
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long surveyId;

	private String name;
	private int amount;
	private boolean status;
	private String desc;

	private String urlId = "https://kyselypalvelufrontti.herokuapp.com/";
	
	
	@JsonIgnoreProperties("survey")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	private List<Question> questions;

	public Survey() {
	}

	public Survey(long surveyId, List<Question> questions) {
		super();
		this.setSurveyId(surveyId);
		this.questions = questions;
	}

	public Survey(String name, boolean status) {
		super();
		this.name = name;
		this.status = status;
	}

	public Survey(String name, boolean status, String desc) {
		super();
		this.name = name;
		this.status = status;
		this.desc = desc;
	}

	public Survey(String name, boolean status, List<Question> questions) {
		super();
		this.name = name;
		this.status = status;
		this.questions = questions;
	}

	public Survey(String name, String desc, boolean status, List<Question> questions) {
		super();
		this.name = name;
		this.desc = desc;
		this.status = status;
		this.questions = questions;
	}
	
	

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {

		return "Survey [surveyId=" + getSurveyId() + ", name=" + name + ", amount=" + amount + ", status=" + status
				+ ", questions= " + ", desc=" + desc;
	}

}
