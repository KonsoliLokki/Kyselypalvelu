package com.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int amount;
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "surveyid")
	private List<Survey> surveys;
	
	public Question(String name, int amount, boolean status, List<Survey> surveys) {
		super();
		this.name = name;
		this.amount = amount;
		this.status = status;
		this.surveys = surveys;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", amount=" + amount + ", status=" + status + ", surveys="
				+ surveys + "]";
	}
}
