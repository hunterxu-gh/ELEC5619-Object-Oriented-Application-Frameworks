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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/view_question_comments/{unitCode}/{questionId}")
public class ViewQuestionCommentsController {
	@Autowired
	private QuestionCommentService questionCommentService;
	@Autowired
	private LoginService loginService;
    @Autowired
    public ViewQuestionCommentsController(QuestionCommentService questionCommentService){
        super();
        this.questionCommentService = questionCommentService;
    }   
    
    @GetMapping
    public String questionListView(Model model, @PathVariable("unitCode") String unitCode,@PathVariable("questionId") Long questionId,HttpServletRequest request){   		   
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        	return "login";
        }
    		model.addAttribute("unit", this.questionCommentService.getUnit(unitCode));
    		model.addAttribute("question",this.questionCommentService.getQuestion(questionId));   
    		model.addAttribute("questionCommentList",this.questionCommentService.fetchQuestionComments(questionId));
    		
    		return "questionCommentListView";
    }
    
    @PostMapping("/delete_question_comment/{questionCommentId}")
    public String deleteQuestionComment(@PathVariable("unitCode") String unitCode,@ModelAttribute Question question,Model model, @PathVariable("questionCommentId") Long questionCommentId,@PathVariable("questionId") Long questionId) {
        this.questionCommentService.deleteQuestionComment(questionCommentId); 
        model.addAttribute("questionCommentList",this.questionCommentService.fetchQuestionComments(questionId));
        model.addAttribute("question",this.questionCommentService.getQuestion(questionId));   
    	return "redirect:/view_question_comments/ELEC5619/1";

    }
    
    @PostMapping("/upvote_question_comment/{questionCommentId}")
    public @ResponseBody Long upvoteQuestionComment(@ModelAttribute Question question, Model model, RedirectAttributes attr,
    									@PathVariable("questionCommentId") Long questionCommentId) {

        QuestionComment updatedQuestionComment = this.questionCommentService.updateVotes(questionCommentId);
        return updatedQuestionComment.getVoteNumbers();
    }
    
    @PostMapping("/downvote_question_comment/{questionCommentId}")
    public @ResponseBody Long downvoteQuestionComment(@ModelAttribute Question question, Model model, RedirectAttributes attr,
    									@PathVariable("questionId") Long questionId,@PathVariable("questionCommentId") Long questionCommentId) {

        QuestionComment updatedQuestionComment = this.questionCommentService.downVotes(questionCommentId);
        return updatedQuestionComment.getDownNumbers();
    }
    
}    