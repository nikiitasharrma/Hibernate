package com.hibernate.OneToOneRelationship;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ans_id")
	private int id;
	
	@Column(name = "answer")
	private String ans;
	
	@OneToOne(mappedBy = "answer")
	private Question ques;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Question getQues() {
		return ques;
	}

	public void setQues(Question ques) {
		this.ques = ques;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", ans=" + ans + ", ques=" + ques + "]";
	}
	
}
