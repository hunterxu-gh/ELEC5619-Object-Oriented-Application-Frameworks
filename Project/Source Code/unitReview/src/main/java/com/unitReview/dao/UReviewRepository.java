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
public interface UReviewRepository extends CrudRepository<UReview, Long>{//<Type,ID>

	ArrayList<UReview> findByUnitCode(String unitCode);
	
	// Added by Wayne. Talk to me if crashed.
	@Query(value="SELECT * from UREVIEW WHERE reviewer=:id",nativeQuery=true)
	ArrayList<UReview> retrieveByReviewerId(@Param("id") long id);
	
	
	// Added by Wayne. Talk to me if crashed.
	@Query(value="SELECT CONCAT(first_name,' ',last_name) FROM IDENTITY WHERE id=:id",nativeQuery=true)
	String getReviewerNameById(@Param("id") long id);
	
	// Added by Rufeng, find the exact review by the unit_review_id
	@Query(value = "select * from UREVIEW where unit_review_id = :uReviewID", nativeQuery=true) 
	UReview findUReviewById(@Param("uReviewID") Long uReviewID);
	
	// Added by Rufeng, update all the field
	@Query(value = "update UREVIEW ur  set ur.difficulty = :difficulty, ur.stress = :stress, ur.usefulness = :usefulness, ur.review_time = :reviewTime, ur.comment = :comment where ur.unit_review_id = :uReviewId", nativeQuery=true) 
	@Modifying
	@Transactional
	void updateUReviewByAll(
			@Param("uReviewId") Long uReviewId,
			@Param("difficulty") int difficulty, 
			@Param("stress") int stress, 
			@Param("usefulness") int usefulness,
			@Param("reviewTime") LocalDateTime reviewTime,
			@Param("comment") String comment
			);
}

