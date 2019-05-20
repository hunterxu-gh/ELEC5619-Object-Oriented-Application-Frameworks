package com.unitReview.Service;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.unitReview.Domain.Student;
import com.unitReview.dao.IdentityRepository;
import com.unitReview.dao.StudentRepository;
import com.unitReview.Domain.Identity;

@Service
public class LoginService{
	private StudentRepository studentRepository;
	private IdentityRepository identityRepository;
	
	@Autowired
	public LoginService(StudentRepository studentRepository,
			IdentityRepository identityRepository) {
		super();
		this.studentRepository=studentRepository;
		this.identityRepository=identityRepository;
	}
	
	public Student userLogin(String email, String passwd) {
		Student student=this.studentRepository.retrieveStudentByEmail(email);
		if (student==null) {
			return null;
		}
		if (BCrypt.checkpw(passwd, student.getPassword())) {
			// login success
			System.out.println("Login success with password: "+passwd+". It's hash: "+student.getPassword());
			return student;
		}
	
		return null;
	}
	
	public Student insertStudent(Student student) {
		Identity identity=(Identity) student;
		String email=identity.getEmail();
		if (this.identityRepository.isEmailExist(email) == 1 ) {
			System.out.println("emial existed! ");
			student.setId(-1);
			return student;
		}
		String avator=identity.getAvator();
		String last_name=identity.getLast_name();
		String first_name=identity.getFirst_name();
		String nationality=identity.getNationality();
		
		String skills=student.getSkills();
		String degree=student.getDegree();
		String password=student.getPassword();
		
		this.identityRepository.saveIdentity(email,avator,last_name, first_name,nationality);
		long id=this.identityRepository.retrieveIdByEmail(email);
		this.studentRepository.saveStudent(id, skills, degree, password);
		student=this.studentRepository.retrieveStudentById(id);
	    return student;
	}
	
    public Student retrieveStudentByEmail(String email) {
    	return this.studentRepository.retrieveStudentByEmail(email);
    }
    
    public boolean isValidSession(HttpServletRequest request) {
    	HttpSession session=request.getSession(false);
    	if (session ==null) {
    		return false;
    	}else if ((boolean)session.getAttribute("loggedin")==false) {
    		return false;
    	}
    	return true;
    }
	
}