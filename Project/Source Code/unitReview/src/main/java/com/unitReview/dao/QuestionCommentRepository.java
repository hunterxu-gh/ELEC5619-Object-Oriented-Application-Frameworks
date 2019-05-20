package com.unitReview.dao;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitReview.Domain.Question;
import com.unitReview.Domain.QuestionComment;
import com.unitReview.Domain.UReview;


@Repository
public interface QuestionCommentRepository extends CrudRepository<QuestionComment, Long>{//<Type,ID>

	@Query(value = "SELECT * FROM QUESTIONCOMMENT u where u.question_id = :questionId", nativeQuery=true) 
	ArrayList<QuestionComment> findByQuestionId(@Param("questionId") Long questionId);
	
	@Query(value = "SELECT * FROM QUESTIONCOMMENT u where u.question_comment_id = :questionCommentId", nativeQuery=true) 
	QuestionComment findByQuestionCommentId(@Param("questionCommentId") Long questionCommentId);
	
}


