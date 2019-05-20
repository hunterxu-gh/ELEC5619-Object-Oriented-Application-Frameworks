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
import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/view_questions/{unitCode}")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private LoginService loginService;
    @Autowired
    public QuestionController(QuestionService questionService){
        super();
        this.questionService = questionService;
    }   
    
    @GetMapping
    public String questionListView(Model model, @PathVariable("unitCode") String unitCode,@ModelAttribute Student student,
    		HttpServletRequest request){
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        	return "login";
        }

    		model.addAttribute("unit", this.questionService.getUnit(unitCode));
    		model.addAttribute("questionList",this.questionService.fetchQuestions(unitCode));   		
    		return "questionListView";
    }
    
    
    
   
    
    


   
    
}