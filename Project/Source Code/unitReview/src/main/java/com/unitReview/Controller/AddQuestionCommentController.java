package com.unitReview.Controller;

import com.unitReview.*;
import com.unitReview.Domain.*;
import com.unitReview.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value="/add_question_comment/{unitCode}/{questionId}/")
public class AddQuestionCommentController {

	@Autowired
	private QuestionCommentService questionCommentService;
	@Autowired
	private LoginService loginService;
    @Autowired
    public AddQuestionCommentController(QuestionCommentService questionCommentService){
        super();
        this.questionCommentService = questionCommentService;
    }   
    
    @GetMapping
    public String addQuestionComment(Model model, @PathVariable("unitCode") String unitCode,@PathVariable("questionId") Long questionId,HttpServletRequest request) {
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        	return "login";
        }
    	model.addAttribute("unit", this.questionCommentService.getUnit(unitCode));
    	model.addAttribute("question", this.questionCommentService.getQuestion(questionId));
    	model.addAttribute("newQuestionComment", new QuestionComment());
    	return "addQuestionComment";
    }
    
    @PostMapping("/submit_question_comment")
    public String submitQuestion(Model model, @PathVariable("unitCode") String unitCode,@PathVariable("questionId") Long questionId,@ModelAttribute QuestionComment newQuestionComment,RedirectAttributes attr) {
    	
    	newQuestionComment.setVoteNumbers(0L);
    	newQuestionComment.setDownNumbers(0L);
    	newQuestionComment.setUnitCode(unitCode);
    	newQuestionComment.setQuestionId(questionId);
    	model.addAttribute("unitCode", unitCode);
    	model.addAttribute("questionId", questionId);
    	model.addAttribute("unit", this.questionCommentService.getUnit(unitCode));
    	model.addAttribute("question", this.questionCommentService.getQuestion(questionId));
    	this.questionCommentService.insertQuestionComment(newQuestionComment);  
    	return "redirect:/view_question_comments/"+newQuestionComment.getUnitCode()+"/"+newQuestionComment.getQuestionId();
    }
    
}
