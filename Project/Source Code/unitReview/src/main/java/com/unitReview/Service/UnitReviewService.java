package com.unitReview.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitReview.Domain.LReview;
import com.unitReview.Domain.UReview;
import com.unitReview.Domain.Unit;
import com.unitReview.dao.TestRepository;
import com.unitReview.dao.UReviewRepository;
import com.unitReview.dao.UnitRepository;


@Service
public class UnitReviewService {
    private UnitRepository unitRepository;
    private UReviewRepository uReviewRepository;
    private TestRepository testRepository;    
    
    @Autowired
    public UnitReviewService(UnitRepository unitReviewRepository, UReviewRepository uReviewRepository, TestRepository testRepository){
        super();
        this.unitRepository = unitReviewRepository;
        this.uReviewRepository = uReviewRepository;
        this. testRepository  = testRepository;    
    }

    public Unit getUnit(String unitCode){
//       Unit unit = this.unitReviewRepository.findUnitByCodeAndYearAndSemester("ELEC5619", 2018, "Semester 2");
        Unit unit = this.unitRepository.findUnitByCodeAndYearAndSemester(unitCode);
    	return unit;
    }
  
    public void insertReview(UReview uReview){
       this.uReviewRepository.save(uReview);
   }
    
    public ArrayList<UReview> fetchReviews(String unitCode){
        return this.uReviewRepository.findByUnitCode(unitCode);
    }
    
    public void deleteReview(Long unitId){
    	this.uReviewRepository.deleteById(unitId);
    }
    
    public UReview updateVotes(Long unitId){
    	UReview uReview = this.uReviewRepository.findById(unitId).get();
    	uReview.setUpvotes(uReview.getUpvotes()+1);
    	return this.uReviewRepository.save(uReview);
    }
    
    //Added by Wayne. Talk to me if crashed
    public ArrayList<UReview> retrieveByReviewerId(long reviewer){
    	return this.uReviewRepository.retrieveByReviewerId(reviewer);
    }
    
    //Added by Wayne. Talk to me if crashed
    public String getReviwerNameById(long id) {
    	return this.uReviewRepository.getReviewerNameById(id);
    }
    
    // Added by Rufeng, different from fetchReviews, this fetchReview only return one review
    public UReview fetchReview(Long reviewId){
    	UReview uReview =  this.uReviewRepository.findUReviewById(reviewId);
    	return uReview;
    }
	// Added by Rufeng, just to update the unit review, this fetchReview only return one review
    public void updateReview(Long uReviewId, int difficulty, int stress, int usefulness, LocalDateTime reviewTime, String comment){
    	this.uReviewRepository.updateUReviewByAll(uReviewId, difficulty, stress, usefulness, reviewTime, comment);
    }
    
//    public void insertTest(Test test){
//        System.out.print("------------------------------" + test.getTestContent());
//       this.testRepository.save(test);
////        this.testRepository.insertInto();
//   }
//    
//    public Test getTest(){
//    	this.testRepository.insertInto();
//       return this.testRepository.findById((long) 1).get();
//   }
}
