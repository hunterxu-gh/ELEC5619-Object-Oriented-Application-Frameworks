package com.unitReview.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LECTURER")
public class Lecturer {
    @Id
    @Column(name="lecturer_id")
    @GeneratedValue
    private long lecturerId;
    
    @Column(name="lecturer_name")
    private String lecturerName;
    
    @Column(name="faculty_school")
    private String facultySchool;
    
    @Column(name="specialty_area")
    private String specialtyArea;
    
    @Column(name="teaching_history")
    private String teachingHistory;
    
    public Lecturer(){
    	super();
    }
    
	public Lecturer(long lecturerId, String lecturerName, String facultySchool, String specialtyArea, String teachingHistory) {
		super();
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		this.facultySchool = facultySchool;
		this.specialtyArea = specialtyArea;
		this.teachingHistory = teachingHistory;
	}
	
	public long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getFacultySchool() {
		return facultySchool;
	}

	public void setFacultySchool(String facultySchool) {
		this.facultySchool = facultySchool;
	}
	
	public String getSpecialtyArea() {
		return specialtyArea;
	}

	public void setSpecialtyArea(String specialtyArea) {
		this.specialtyArea = specialtyArea;
	}
	
	public String getTeachingHistory() {
		return teachingHistory;
	}

	public void setTeachingHistory(String teachingHistory) {
		this.teachingHistory = teachingHistory;
	}
	

}
