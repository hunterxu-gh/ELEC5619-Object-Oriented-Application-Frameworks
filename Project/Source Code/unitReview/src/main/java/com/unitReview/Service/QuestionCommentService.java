package com.unitReview.Service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unitReview.Domain.*;
import com.unitReview.dao.*;

@Service
public class QuestionCommentService {
    private QuestionCommentRepository questionCommentRepository;
    private UnitRepository unitRepository;
    private QuestionRepository questionRepository;
    
    @Autowired
    public QuestionCommentService(UnitRepository unitReviewRepository, QuestionRepository questionRepository,QuestionCommentRepository questionCommentRepository){
        super();
        this.unitRepository = unitReviewRepository;
        this.questionRepository = questionRepository;
        this.questionCommentRepository = questionCommentRepository;
    }
    
    public Unit getUnit(String unitCode){
    	Unit unit = this.unitRepository.findUnitByCodeAndYearAndSemester(unitCode);
   		return unit;
   }
    public Question getQuestion(Long questionId){
    	Question question = this.questionRepository.findByQuestionId(questionId);
   		return question;
   }
    public QuestionComment getQuestionComment(Long questionCommentId) {
    	QuestionComment questionComment = this.questionCommentRepository.findByQuestionCommentId(questionCommentId);
    	return questionComment;
    }
    
    public void insertQuestionComment(QuestionComment newQuestionComment){
       this.questionCommentRepository.save(newQuestionComment);
   }
    
    
    public ArrayList<QuestionComment> fetchQuestionComments(Long questionId){
        return this.questionCommentRepository.findByQuestionId(questionId);
    }
    
    public void deleteQuestionComment(Long questionCommentId){
    	this.questionCommentRepository.deleteById(questionCommentId);
    }
    
    public QuestionComment updateVotes(Long questionCommentId){
    	QuestionComment questionComment = this.questionCommentRepository.findById(questionCommentId).get();
    	questionComment.setVoteNumbers(questionComment.getVoteNumbers()+1);
    	return this.questionCommentRepository.save(questionComment);
    }
    
    public QuestionComment downVotes(Long questionCommentId){
    	QuestionComment questionComment = this.questionCommentRepository.findById(questionCommentId).get();
    	questionComment.setDownNumbers(questionComment.getDownNumbers()+1);
    	return this.questionCommentRepository.save(questionComment);
    }
}

    
    
    

