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
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value="/add_question/{unitCode}")
public class AddQuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private LoginService loginService;
	
    @Autowired
    public AddQuestionController(QuestionService questionService){
        super();
        this.questionService = questionService;
    }   
    
    @GetMapping
    public String addQuestion(Model model, @PathVariable("unitCode") String unitCode,HttpServletRequest request) {
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        	return "login";
        }
    	model.addAttribute("unit", this.questionService.getUnit(unitCode));
    	model.addAttribute("newQuestion", new Question());
    	return "addQuestion";
    }
    
    @PostMapping("/submit_question")
    public String submitQuestion(Model model, @PathVariable("unitCode") String unitCode,@ModelAttribute Question newQuestion,RedirectAttributes attr) {
    	
    	newQuestion.setVoteNumber(0L);
    	this.questionService.insertQuestion(newQuestion);  
    	model.addAttribute("unit", this.questionService.getUnit(unitCode));
    	return "redirect:/view_questions/"+newQuestion.getUnitCode();
    }
    
}
