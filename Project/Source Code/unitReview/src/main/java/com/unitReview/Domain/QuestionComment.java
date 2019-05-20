package com.unitReview.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONCOMMENT")
public class QuestionComment {
    @Id
    @Column(name="question_comment_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long questionCommentId;
    
    @Column(name="unit_code")
    private String unitCode;
    
    @Column(name="question_id")
    private long questionId;
    @Column(name="user_id")
    private long userId;

    @Column(name="comment_content")
    private String commentContent;

    @Column(name="vote_numbers")
    private Long voteNumbers;
    @Column(name="down_numbers")
    private Long downNumbers;
    
    public QuestionComment(){
    	super();
    }
    
	public QuestionComment(long questionCommentId,String unitCode, long questionId, long userId, String commentContent,Long voteNumbers,Long downNumbers){
		super();
		this.questionCommentId = questionCommentId;
		this.unitCode = unitCode;
		this.questionId = questionId;
		this.userId = userId;
		this.commentContent = commentContent;
		this.voteNumbers = voteNumbers;
		this.downNumbers = downNumbers;
	}

	
	public long getQuestionCommentId() {
		return questionCommentId;
	}

	public void setQuestionCommentId(long questionCommentId) {
		this.questionCommentId = questionCommentId;
	}
	
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	
	public Long getVoteNumbers() {
		return voteNumbers;
	}

	public void setVoteNumbers( Long voteNumbers) {
		this.voteNumbers = voteNumbers;
	}
	
	public Long getDownNumbers() {
		return downNumbers;
	}

	public void setDownNumbers( Long downNumbers) {
		this.downNumbers = downNumbers;
	}
	@Override
	public String toString() {
		return "Question [questionId = " + questionId + ", userId=" +userId+ ", commentContent=" + commentContent + "]";
	}

    
}
