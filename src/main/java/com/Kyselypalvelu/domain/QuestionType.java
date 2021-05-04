package com.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long typeId;
	private String typename;

	public QuestionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionType(long typeId, String typename) {
		super();
		this.typeId = typeId;
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
