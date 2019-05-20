package com.unitReview.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitReview.Domain.LReview;
import com.unitReview.Domain.UReview;


@Repository
public interface LReviewRepository extends CrudRepository<LReview, Long>{//<Type,ID>
	@Query(value = "select * from LREVIEW where lecturer_id = :lecturerId order by UPVOTES DESC", nativeQuery=true) 
	ArrayList<LReview> findLReviewsByLecturerId(@Param("lecturerId") Long lecturerId);
	
	@Query(value = "select * from LREVIEW where lecturer_review_id = :lReviewID ", nativeQuery=true) 
	LReview findLReviewById(@Param("lReviewID") Long lReviewID);
	
	
	@Query(value = "update LREVIEW lr  set lr.ability = :ability, lr.responsiveness = :responsiveness,  lr.review_time = :reviewTime, lr.comment = :comment where lr.lecturer_review_id = :lReviewId", nativeQuery=true) 
	@Modifying
	@Transactional
	void updateLReviewByAll(
			@Param("lReviewId") Long lReviewId,
			@Param("ability") int ability, 
			@Param("responsiveness") int responsiveness,
			@Param("reviewTime") LocalDateTime reviewTime,
			@Param("comment") String comment
			);
	/*
	@Modifying
	@Transactional
	@Query(value = "update LREVIEW lr  set lr.ability = :ability, lr.responsiveness = :responsiveness,  lr.review_time = :reviewTime, lr.comment = :comment where lr.lecturer_review_id = :lReviewID", nativeQuery=true) 
	void updateLReviewByAll(@Param("lReviewID") Long lReviewID);
	*/
	
	// Added by Wayne. Talk to me if crashed.
	@Query(value="SELECT * FROM LREVIEW WHERE reviewer=:id",nativeQuery=true)
	ArrayList<LReview> retrieveByReviewerId(@Param("id") long id);
}

