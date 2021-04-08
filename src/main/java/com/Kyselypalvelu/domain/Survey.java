package com.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Survey {

	// long id, string name, int amount, status bool
	private @Id @GeneratedValue(strategy=GenerationType.AUTO) long surveyId;
	private String name;
	private int amount;
	private boolean status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	private List<Question> questions;
	
	public Survey() {}
	
	

	public Survey(long surveyId, String name, int amount, boolean status) {
		super();
		this.surveyId = surveyId;
		this.name = name;
		this.amount = amount;
		this.status = status;
	}



	public Survey(String name, int amount, boolean status, List<Question> questions) {
		super();
		this.name = name;
		this.amount = amount;
		this.status = status;
		this.questions = questions;
	}

	public Long getId() {
		return surveyId;
	}

	public void setId(long surveyId) {
		this.surveyId = surveyId;
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
		return "Survey [surveyId=" + surveyId + ", name=" + name + ", amount=" + amount + ", status=" + status + ", questions="
				+ questions + "]";
	}
	
	
	
}
