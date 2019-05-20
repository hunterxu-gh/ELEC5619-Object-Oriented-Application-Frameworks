package com.unitReview.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitReview.Domain.LReview;
import com.unitReview.Domain.Lecturer;
import com.unitReview.Domain.UReview;
import com.unitReview.dao.LReviewRepository;
import com.unitReview.dao.LecturerRepository;
import com.unitReview.dao.TestRepository;

@Service
public class LecturerReviewService {
	private LecturerRepository lecturerRepository;
	private LReviewRepository lReviewRepository;
	private TestRepository testRepository;
	
	@Autowired
	public LecturerReviewService(LecturerRepository lecturerReviewRepository, LReviewRepository lReviewRepository, TestRepository testRepository){
		super();
		this.lecturerRepository = lecturerReviewRepository;
		this.lReviewRepository = lReviewRepository;
		this. testRepository  = testRepository;
	}
	
	public Lecturer fetchLecturer(Long lecturerId){
		Lecturer lecturer = this.lecturerRepository.findLecturerById(lecturerId);
		return lecturer;
	}
  
    public void insertReview(LReview lReview){
       this.lReviewRepository.save(lReview);
   }
    
    public ArrayList<LReview> fetchReviews(Long lecturerId){
        return this.lReviewRepository.findLReviewsByLecturerId(lecturerId);
    }
    
    public LReview fetchReview(Long reviewId){
    	LReview lReview =  this.lReviewRepository.findLReviewById(reviewId);
    	return lReview;
    }
    
    public void deleteReview(Long lecturerReviewId){
    	this.lReviewRepository.deleteById(lecturerReviewId);
    }
    
    public LReview updateVotes(Long lecturerId){
    	LReview lReview = this.lReviewRepository.findById(lecturerId).get();
    	lReview.setUpvotes(lReview.getUpvotes()+1);
    	return this.lReviewRepository.save(lReview);
    }
    
    public void updateReview(Long lReviewId, int ability, int responsiveness, LocalDateTime reviewTime, String comment){
    	this.lReviewRepository.updateLReviewByAll(lReviewId, ability, responsiveness, reviewTime, comment);
    }
    
    //Added by Wayne. Talk to me if crashed
    public ArrayList<LReview> retrieveByReviewerId(long reviewer){
    	return this.lReviewRepository.retrieveByReviewerId(reviewer);
    }
	
}
