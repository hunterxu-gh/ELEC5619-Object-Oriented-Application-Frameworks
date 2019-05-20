package com.unitReview.dao;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitReview.Domain.Question;
import com.unitReview.Domain.UReview;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{//<Type,ID>

	@Query(value = "SELECT * FROM QUESTION u where u.unit_code = :unitCode", nativeQuery=true) 
	ArrayList<Question> findByUnitCode(@Param("unitCode") String unitCode);
	
	@Query(value = "SELECT * FROM QUESTION u where u.question_id = :questionId", nativeQuery=true) 
	Question findByQuestionId(@Param("questionId") Long questionId);
	
}


