package com.unitReview.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitReview.Domain.LReview;
import com.unitReview.Domain.Student;
import com.unitReview.Domain.UReview;
import com.unitReview.Service.LecturerReviewService;
import com.unitReview.Service.LoginService;
import com.unitReview.Service.UnitReviewService;

import java.time.LocalDateTime;
import com.unitReview.Domain.*;
import java.util.ArrayList;


@Controller
@RequestMapping("/lecturer/{lecturerIdString}")
public class LecturerReviewController {

	@Autowired
    private LecturerReviewService LecturerReviewService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private UnitReviewService unitReviewService;
	
	private class revieNameMapping{
		public LReview review;
		public String reviewerName;
		
		public revieNameMapping(LReview lReview) {
			this.review=lReview;
			this.reviewerName=LecturerReviewController.this.unitReviewService.getReviwerNameById(review.getReviewer());
		}
	}
	
    @GetMapping
    public String getAllRooms(
    		Model model, 
    		@PathVariable("lecturerIdString") Long lecturerId,
    		HttpServletRequest request){
    	if (this.loginService.isValidSession(request)) {
        	model.addAttribute("islogin", true);
        }
    	ArrayList<LReview> rawList=this.LecturerReviewService.fetchReviews(lecturerId);
    	ArrayList<revieNameMapping> reviewList=new ArrayList<revieNameMapping>();
    	for (LReview review: rawList) {
    		reviewList.add(new revieNameMapping(review));
    	}
    	HttpSession session= request.getSession(false);
    	if (session!=null) {
    	Student reviewer = (Student)session.getAttribute("student");
    	model.addAttribute("studentName", 
				reviewer.getFirst_name() + " " +
						reviewer.getLast_name()); 
    	}else {
    		model.addAttribute("studentName", "Anonymous visitor");
    	}
        model.addAttribute("lecturer", this.LecturerReviewService.fetchLecturer(lecturerId));
        model.addAttribute("reviewList", reviewList);
        model.addAttribute("newReview", new LReview());
        return "lecturerReview";
    }

    @PostMapping("/submit_review")
    public String submitReview(@ModelAttribute LReview newReview, Model model, RedirectAttributes attr, 
    							@PathVariable("lecturerIdString") Long lecturerId,
    							 HttpServletRequest request){
        if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("error", "Please Login to submit");
        	return "login";
        }
        newReview.setReviewTime(LocalDateTime.now());
        Student student=(Student)request.getSession(false).getAttribute("student");
        newReview.setReviewer(student.getId());
        this.LecturerReviewService.insertReview(newReview);
        // TODO: modify the insertReview() in LecturerReviewService

        return "redirect:/lecturer/{lecturerIdString}";
    }
    
    @PostMapping("/delete_review/{lReviewIdString}")
    public String deleteReview(@ModelAttribute LReview newReview, Model model, RedirectAttributes attr,
    							@PathVariable("lecturerIdString") Long lecturerId, 
    							@PathVariable("lReviewIdString") Long reviewId,
    							HttpServletRequest request) {
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("error", "Please Login to delete");
        	return "login";
        }
    	//long lecturerId = Long.parseLong(lecturerIdString);
    	//long reviewId = Long.parseLong(reviewIdString);
        this.LecturerReviewService.deleteReview(reviewId);
        

        return "redirect:/lecturer/{lecturerIdString}";
    }
    
    @PostMapping("/update_votes/{lReviewIdString}")
    public @ResponseBody int updateVote(@ModelAttribute LReview newReview, Model model, RedirectAttributes attr,
    									@PathVariable("lecturerIdString") Long lecturerId, 
    									@PathVariable("lReviewIdString") Long lReviewId) {
        LReview updatedLReview = this.LecturerReviewService.updateVotes(lReviewId);
        return updatedLReview.getUpvotes();
    }
    
    @GetMapping("/edit_review/{lReviewIdString}")
    public String editReview(Model model, @PathVariable("lecturerIdString") Long lecturerId, 
    										@PathVariable("lReviewIdString") Long lReviewId){
    	model.addAttribute("lecturer", this.LecturerReviewService.fetchLecturer(lecturerId));
        model.addAttribute("review", this.LecturerReviewService.fetchReview(lReviewId));
        model.addAttribute("newReview", new LReview());
    	return "editLReview";
    }
    
    @PostMapping("/update_review/{lReviewIdString}")
    public String updateReview(@ModelAttribute LReview updatedReview, Model model, RedirectAttributes attr, 
    							@PathVariable("lecturerIdString") Long lecturerId,
    							@PathVariable("lReviewIdString") Long lReviewId,
    							HttpServletRequest request){
    	if (!this.loginService.isValidSession(request)) {
        	model.addAttribute("error", "Please Login to edit");
        	return "login";
        }
    	int ability = updatedReview.getAbility();
    	int responsiveness = updatedReview.getResponsiveness();
    	String comment = updatedReview.getComment();
    	updatedReview.setReviewTime(LocalDateTime.now());
    	LocalDateTime reviewTime = updatedReview.getReviewTime();
        this.LecturerReviewService.updateReview(lReviewId, ability, responsiveness, reviewTime, comment);

        return "redirect:/lecturer/{lecturerIdString}";
    }
    
    
    
}