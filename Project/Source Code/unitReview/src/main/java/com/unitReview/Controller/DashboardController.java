package com.unitReview.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.unitReview.Domain.*;
import com.unitReview.Service.LecturerReviewService;
import com.unitReview.Service.LoginService;
import com.unitReview.Service.UnitReviewService;

@Controller
public class DashboardController {
	@Autowired
	private UnitReviewService unitReviewService;
	@Autowired
	private LecturerReviewService lecturerReviewService;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/dashboard")
	public String getUserDashboard(
			Model model,
			HttpServletRequest request) {
		HttpSession session= request.getSession(false);
		if (session == null|| session.getAttribute("loggedin")==null) {
			model.addAttribute("error", "Opps you're not logged in.");
			return "login";
		}
		Student student=(Student)session.getAttribute("student");
		model.addAttribute("student", student );
    	model.addAttribute("myUnitReviews", this.unitReviewService.retrieveByReviewerId(student.getId()));
    	model.addAttribute("myLectReviews", this.lecturerReviewService.retrieveByReviewerId(student.getId()));
    	return "dashboard";
	}

}
