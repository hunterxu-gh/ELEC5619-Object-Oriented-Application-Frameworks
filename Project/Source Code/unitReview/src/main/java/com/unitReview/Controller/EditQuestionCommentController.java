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
@RequestMapping(value="/edit_question_comment/{unitCode}/{questionId}/{questionCommentId}/")
public class EditQuestionCommentController {

	@Autowired
	private QuestionCommentService questionCommentService;
	@Autowired
	private LoginService loginService;
    @Autowired
    public EditQuestionCommentController(QuestionCommentService questionCommentService){
        super();
        this.questionCommentService = questionCommentService;
    }   
    
    @GetMapping
    public String editQuestion(Model model, @PathVariable("unitCode") String unitCode,
    		@PathVariable("questionId") Long questionId,
    		@PathVariable("questionCommentId") Long questionCommentId
    		,HttpServletRequest request) {
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        	return "login";
        }
    	model.addAttribute("unit", this.questionCommentService.getUnit(unitCode));
    	model.addAttribute("question", this.questionCommentService.getQuestion(questionId));
    	model.addAttribute("questionComment", this.questionCommentService.getQuestionComment(questionCommentId));   
    	
    	return "editQuestionComment";
    }
    
    @PostMapping("/update_question_comment")
    public String updateQuestionComment( Model model, 
    		@PathVariable("unitCode") String unitCode,
    		@PathVariable("questionId") Long questionId,
    		@PathVariable("questionCommentId") Long questionCommentId,
    		@ModelAttribute QuestionComment questionComment,
    		RedirectAttributes attr) {
    	
    	this.questionCommentService.insertQuestionComment(questionComment);  
  
    	return "redirect:/view_question_comments/"+questionComment.getUnitCode()+"/"+questionComment.getQuestionId();
    }
    
}
