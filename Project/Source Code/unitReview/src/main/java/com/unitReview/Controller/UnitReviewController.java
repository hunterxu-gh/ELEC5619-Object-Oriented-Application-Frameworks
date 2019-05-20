package com.unitReview.Controller;

import java.util.ArrayList;
import java.util.HashMap;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.unitReview.Service.LoginService;
import com.unitReview.Service.UnitReviewService;

import java.time.LocalDateTime;
import com.unitReview.Domain.*;


@Controller
@RequestMapping("/unit_review/{unitCode}")
public class UnitReviewController {

	@Autowired
    private UnitReviewService unitReviewService;
    @Autowired
    private LoginService loginService;
    
    // The justification for this strange class is demonstrated below
    private class revieNameMapping{
		public UReview review;
		public String reviewerName;
		
		public revieNameMapping(UReview review) {
			this.review=review;
			this.reviewerName=UnitReviewController.this.unitReviewService.getReviwerNameById(review.getReviewer());
		}
	}
    @GetMapping
    public String getAllRooms(Model model, 
    		@PathVariable("unitCode") String unitCode, 
    		@ModelAttribute Student student,
    		HttpServletRequest request){
    	if (this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        }

    	ArrayList<UReview> rawList=this.unitReviewService.fetchReviews(unitCode);
    	ArrayList<revieNameMapping> reviewList=new ArrayList<revieNameMapping>();
    	for (UReview review: rawList) {
    		reviewList.add(new revieNameMapping(review));
    	}
    	HttpSession session= request.getSession(false);
    	if (session !=null) {
    	Student reviewer=(Student)session.getAttribute("student");

		model.addAttribute("studentName", 
				reviewer.getFirst_name() + " " +
						reviewer.getLast_name()); 
    	}else {
    		model.addAttribute("studentName", "Anonymous visitor");
    	}
        model.addAttribute("unit", this.unitReviewService.getUnit(unitCode));
        model.addAttribute("reviewList", reviewList);
        model.addAttribute("newReview", new UReview());
        return "unitReview";
    }

    @PostMapping("/submit_review")
    public String greetingSubmit(
    		@ModelAttribute UReview newReview, 
    		@ModelAttribute Student student,
    		Model model, 
    		RedirectAttributes attr, 
    		@PathVariable("unitCode") String unitCode,
    		HttpServletRequest request) {
    	
	    	if (!this.loginService.isValidSession(request)) {
	        	model.addAttribute("error", "Please Login to submit");
	        	return "login";
	        }
	        newReview.setReviewTime(LocalDateTime.now());
	        Student s=(Student)request.getSession(false).getAttribute("student");
	        newReview.SetReviewer(s.getId());
	        this.unitReviewService.insertReview(newReview);
	        //TODO: if binding has errors
	        System.out.println(newReview);
	
	        return "redirect:/unit_review/{unitCode}";
    }
    
    @PostMapping("/delete/{unitId}")
    public String deleteReview(
    		@ModelAttribute UReview newReview, 
    		@ModelAttribute Student student,
    		Model model, 
    		RedirectAttributes attr,
    		@PathVariable("unitId") String unitIdString, 
    		@PathVariable("unitCode") String unitCode,
    		HttpServletRequest request) {
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("error", "Please Login to delete");
        	return "login";
        }
    	long unitId = Long.parseLong(unitIdString);
        this.unitReviewService.deleteReview(unitId);
        //TODO: if binding has errors

        return "redirect:/unit_review/{unitCode}";
    }

    @PostMapping("/updateVotes/{unitId}")
    public @ResponseBody int updateVote(@ModelAttribute UReview newReview, Model model, RedirectAttributes attr,
    		@PathVariable("unitId") String unitIdString, @PathVariable("unitCode") String unitCode) {

    	long unitId = Long.parseLong(unitIdString);
        UReview updatedUReview = this.unitReviewService.updateVotes(unitId);
        //TODO: if binding has errors

        return updatedUReview.getUpvotes();
    }
    
    
    // Added by Rufeng, for edit unit review
    @GetMapping("/edit_review/{uReviewIdString}")
    public String editReview(Model model, @PathVariable("unitCode") String unitCode, 
    										@PathVariable("uReviewIdString") Long uReviewId){
    	model.addAttribute("unit", this.unitReviewService.getUnit(unitCode));
        model.addAttribute("review", this.unitReviewService.fetchReview(uReviewId));
        model.addAttribute("newReview", new LReview());
    	return "editUReview";
    }
    
    // Added by Rufeng, for edit unit review
    @PostMapping("/update_review/{uReviewIdString}")
    public String updateReview(@ModelAttribute UReview updatedReview, Model model, RedirectAttributes attr, 
    							@PathVariable("unitCode") String unitCode,
    							@PathVariable("uReviewIdString") Long uReviewId,
    							HttpServletRequest request){
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("error", "Please Login to edit");
        	return "login";
        }
    	int difficulty = updatedReview.getDifficulty();
    	int stress = updatedReview.getStress();
    	int usefulness = updatedReview.getUsefulness();
    	String comment = updatedReview.getComment();
    	updatedReview.setReviewTime(LocalDateTime.now());
    	LocalDateTime reviewTime = updatedReview.getReviewTime();
        this.unitReviewService.updateReview(uReviewId, difficulty, stress, usefulness, reviewTime, comment);

        return "redirect:/unit_review/{unitCode}";
    }
}