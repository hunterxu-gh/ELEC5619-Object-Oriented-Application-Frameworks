package com.unitReview.Service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unitReview.Domain.*;
import com.unitReview.dao.*;
@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private UnitRepository unitRepository;
    
    @Autowired
    public QuestionService(UnitRepository unitReviewRepository, QuestionRepository questionRepository){
        super();
        this.unitRepository = unitReviewRepository;
        this.questionRepository = questionRepository;
   
    }
    
    public Unit getUnit(String unitCode){
//      Unit unit = this.unitReviewRepository.findUnitByCodeAndYearAndSemester("ELEC5619", 2018, "Semester 2");
       Unit unit = this.unitRepository.findUnitByCodeAndYearAndSemester(unitCode);
   		return unit;
   }
    public Question getQuestion(Long questionId) {
    	Question question = this.questionRepository.findByQuestionId(questionId);
    	return question;
    }
    public void insertQuestion(Question question){
       this.questionRepository.save(question);
   }
    
    public ArrayList<Question> fetchQuestions(String unitCode){
        return this.questionRepository.findByUnitCode(unitCode);
    }
    
    public void deleteQuestion(Long questionId){
    	this.questionRepository.deleteById(questionId);
    }
    
    public Question updateVotes(Long questionId){
    	Question question = this.questionRepository.findById(questionId).get();
    	question.setVoteNumber(question.getVoteNumber()+1);
    	return this.questionRepository.save(question);
    }
    
    public Question downVotes(Long questionId){
    	Question question = this.questionRepository.findById(questionId).get();
    	question.setDownNumber(question.getDownNumber()+1);
    	return this.questionRepository.save(question);
    }
}

    
    
    

