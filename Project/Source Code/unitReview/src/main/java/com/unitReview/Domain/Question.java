package com.unitReview.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION")
public class Question {
    @Id
    @Column(name="question_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long questionId;
    @Column(name="question_title")
    private String questionTitle;
    @Column(name="user_id")
    private long userId;
    @Column(name="unit_code")
    private String unitCode;
    @Column(name="question_content")
    private String questionContent;
    @Column(name="sample_answer")
    private String sampleAnswer;
    @Column(name="vote_number")
    private Long voteNumber;
    @Column(name="down_number")
    private Long downNumber;
    public Question(){
    	super();
    }
    
	public Question(long questionId,String questionTitle, String unitCode,long userId, String questionContent,String sampleAnswer,Long voteNumber,Long downNumber) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.unitCode = unitCode;
		this.userId = userId;
		this.questionContent = questionContent;
		this.sampleAnswer = sampleAnswer;
		this.voteNumber = voteNumber;
		this.downNumber = downNumber;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	
	public String getSampleAnswer() {
		return sampleAnswer;
	}

	public void setSampleAnswer(String sampleAnswer) {
		this.sampleAnswer = sampleAnswer;
	}
	
	public Long getVoteNumber() {
		return voteNumber;
	}

	public void setVoteNumber( Long voteNumber) {
		this.voteNumber = voteNumber;
	}
	
	public Long getDownNumber() {
		return downNumber;
	}

	public void setDownNumber( Long downNumber) {
		this.downNumber = downNumber;
	}
	
	@Override
	public String toString() {
		return "Question [questionId = " + questionId + ", unitId=" +unitCode+ ", questionContent=" + questionContent + "]";
	}

    
}
