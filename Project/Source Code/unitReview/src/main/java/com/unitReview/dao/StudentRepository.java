package com.unitReview.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitReview.Domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	@Query(value="SELECT s.id, first_name, last_name, email, avator, nationality, degree, skills, password"
			+ " FROM "
			+ "STUDENT s JOIN IDENTITY i ON i.id=s.id "
			+ "WHERE i.email=:email ",nativeQuery=true)
	Student retrieveStudentByEmail(@Param("email")String email);
	
	@Query(value="INSERT INTO STUDENT (id, skills, degree, password) VALUES "
			+ "("
			+ ":id,"
			+ ":skills,"
			+ ":degree,"
			+ ":password)",nativeQuery=true)
	@Modifying
	@Transactional
	void saveStudent(
			@Param("id")long id,
			@Param("skills")String skills,
			@Param("degree")String degree,
			@Param("password")String password);
	
	@Query(value="SELECT s.id, first_name, last_name, email, avator, nationality, degree, skills, password"
			+ " FROM "
			+ "STUDENT s JOIN IDENTITY i ON i.id=s.id "
			+ "WHERE s.id=:id",nativeQuery=true)
	Student retrieveStudentById(@Param("id") long id);
	
}
