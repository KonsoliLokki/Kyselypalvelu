package com.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class QuestionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long typeId;
	private String typename;

	@JsonIgnore
	@JsonIgnoreProperties({ "type", "quetext", "status", "required", "survey" })
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questiontype")
	private List<Question> questions;

	public QuestionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionType(String typename) {
		super();
		this.typename = typename;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "QuestionType [typeId=" + typeId + ", typename=" + typename + "]";
	}
}
