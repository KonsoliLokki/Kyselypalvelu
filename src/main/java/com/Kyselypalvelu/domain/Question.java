package com.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int amount;
	private boolean status;
	
	// ManyToOne suhde Survey luokkaan?
	
	public Question(String name, int amount, boolean status) {
		super();
		this.name = name;
		this.amount = amount;
		this.status = status;
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", amount=" + amount + ", status=" + status + "]";
	}
}
