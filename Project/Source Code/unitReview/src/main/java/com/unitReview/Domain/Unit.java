package com.unitReview.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIT")
public class Unit {
    @Id
    @Column(name="unitId")
    @GeneratedValue
    private long unitId;

    @Column(name="unitCode")
    private String unitCode;
    
    @Column(name="unitName")
    private String unitName;
 
    @Column(name="unitYear")
    private int unitYear;
    
    @Column(name="unitSemester")
    private String unitSemester;

    @Column(name="unitMode")
    private String unitMode;
    
    @Column(name="facultySchool")
    private String facultySchool;
    
    @Column(name="lecturer")
    private String lecturer;
    
    @Column(name="sessionOption")
    private String sessionOption;

    
    public Unit(){
    	super();
    }
    
	public Unit(long unitId, String unitName, String unitCode, String unitMode, String facultySchool, String lecturer,
			String sessionOption) {
		super();
		this.unitId = unitId;
		this.unitName = unitName;
		this.unitCode = unitCode;
		this.unitMode = unitMode;
		this.facultySchool = facultySchool;
		this.lecturer = lecturer;
		this.sessionOption = sessionOption;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitMode() {
		return unitMode;
	}

	public void setUnitMode(String unitMode) {
		this.unitMode = unitMode;
	}

	public String getFacultySchool() {
		return facultySchool;
	}

	public void setFacultySchool(String facultySchool) {
		this.facultySchool = facultySchool;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getSessionOption() {
		return sessionOption;
	}

	public void setSessionOption(String sessionOption) {
		this.sessionOption = sessionOption;
	}
}
