package com.unitReview.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student extends Identity implements java.io.Serializable{
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="password")
	private String password;
	
	public Student() {
		super();
	}

	public Student(long id, String firstName, String lastName, String email, String avator, String nationality,
			String degree, String skills, String password) {
		super(id, firstName, lastName, email, avator, nationality);
		this.degree = degree;
		this.skills = skills;
		this.password=password;
	}

	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public void setPassword(String pass) {
		this.password=pass;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
	@Override
	public String toString() {
		return "This a toString overriden for Student:"
				+ ", student ID: "+this.getId()
				+ ", Avator: "+this.getAvator()
				+ ", degree: "+this.getDegree()
				+ ", email: "+this.getEmail()
				+ ", skills: "+this.getSkills()
				+ ", natioanality: "+this.getNationality()
				+ ", name: "+this.getFirst_name()+" "+this.getLast_name();
	}
	
}