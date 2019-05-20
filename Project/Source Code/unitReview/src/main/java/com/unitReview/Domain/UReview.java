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
@Table(name="UREVIEW")
public class UReview {
	
    @Id
    @Column(name="unitReviewId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long unitReviewId;
    
    @Column(name="unitId")
    private long unitId;
    
    @Column(name="unitCode")
    private String unitCode;
    
    @Column(name="difficulty")
    private int difficulty;
    
    @Column(name="stress")
    private int stress; 
    
    @Column(name="usefulness")    
    private int usefulness;   
    
    @Column(name="upvotes")     
    private int upvotes;    
    
    @Column(name="reviewTime")    
    private LocalDateTime reviewTime;
    
    @Column(name="comment")    
    private String comment;
    
    @Column(name="reviewer")
    private long reviewer;
    
    public UReview(){
    	super();
    }
    
	public UReview(long unitReviewId, long unitId, String unitCode, int difficulty, int stress, int usefulness,
			int upvotes, LocalDateTime reviewTime, String comment, long reviewer) {
		super();
		this.unitReviewId = unitReviewId;
		this.unitId = unitId;
		this.unitCode = unitCode;
		this.difficulty = difficulty;
		this.stress = stress;
		this.usefulness = usefulness;
		this.upvotes = upvotes;
		this.reviewTime = reviewTime;
		this.comment = comment;
		this.reviewer= reviewer;
	}
	
	public long getReviewer() {
		return reviewer;
	}

    public void SetReviewer(long reviewer) {
    	this.reviewer=reviewer;
    }

	public long getUnitReviewId() {
		return unitReviewId;
	}

	public void setUnitReviewId(long unitReviewID) {
		this.unitReviewId = unitReviewID;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getUsefulness() {
		return usefulness;
	}

	public void setUsefulness(int usefulness) {
		this.usefulness = usefulness;
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

	
	
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	@Override
	public String toString() {
		return "UReview [unitReviewId=" + unitReviewId + ", unitId=" + unitId + ", difficulty=" + difficulty
				+ ", stress=" + stress + ", usefulness=" + usefulness + ", upvotes=" + upvotes + ", reviewTime="
				+ reviewTime + ", comment=" + comment + "]";
	}


}
