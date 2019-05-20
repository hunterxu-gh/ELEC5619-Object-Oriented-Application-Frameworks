package com.unitReview.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST")
public class Test {
    @Id
    @Column(name="testId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long testID;

    @Column(name="testContent")
    private String testContent;

    public Test(){
    	super();
    }
    
	public Test(long testID, String testContent) {
		super();
		this.testID = testID;
		this.testContent = testContent;
	}

	public long getTestID() {
		return testID;
	}

	public void setTestID(long testID) {
		this.testID = testID;
	}

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}

	@Override
	public String toString() {
		return "Test [testID=" + testID + ", testContent=" + testContent + "]";
	}

    
}
