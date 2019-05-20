package com.unitReview.Domain;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LREVIEW")
public class LReview {
	
    @Id
    @Column(name="LECTURER_REVIEW_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long lReviewId;
    
    @Column(name="LECTURER_ID")
    private long lecturerId;
    
    @Column(name="ABILITY")
    private int ability;
    
    @Column(name="RESPONSIVENESS")
    private int responsiveness; 
    
    @Column(name="UPVOTES")     
    private int upvotes;    
    
    @Column(name="REVIEW_TIME")    
    private LocalDateTime reviewTime;
    
    @Column(name="COMMENT")    
    private String comment;
    
    @Column(name="REVIEWER")
    private long reviewer;
    
    public LReview(){
    	super();
    }
    
	public LReview(long lReviewId, Long lecturerId, int ability, int responsiveness, int upvotes, 
			LocalDateTime reviewTime, String comment, long reviewer) {
		super();
		this.lReviewId = lReviewId;
		this.lecturerId = lecturerId;
		this.ability = ability;
		this.responsiveness = responsiveness;
		this.upvotes = upvotes;
		this.reviewTime = reviewTime;
		this.comment = comment;
		this.reviewer=reviewer;
	}

   public long getReviewer() {
	   return reviewer;
   }
   
   public void setReviewer(long reviewer) {
	   this.reviewer=reviewer;
   }

	public long getLecturerReviewId() {
		return lReviewId;
	}

	public void setLecturerReviewId(long lReviewId) {
		this.lReviewId = lReviewId;
	}

	public long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getResponsiveness() {
		return responsiveness;
	}

	public void setResponsiveness(int responsiveness) {
		this.responsiveness = responsiveness;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public LocalDateTime getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(LocalDateTime reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	@Override
	public String toString() {
		return "LReview [lReviewId=" + lReviewId + ", lecturerId=" + lecturerId + ", teachingAbility=" + ability
				+ ", responsiveness=" + responsiveness + ", upvotes=" + upvotes + ", reviewTime=" + reviewTime + ", comment=" + comment + "]";
	}
	
}
