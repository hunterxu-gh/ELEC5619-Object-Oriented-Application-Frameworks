package com.unitReview.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.unitReview.Domain.*;
import com.unitReview.Service.LoginService;
import com.unitReview.Service.SearchService;

import java.util.List;
import java.util.ArrayList;

// This controller actually ... maps both index and the search box.
@Controller
public class IndexPageController {
	
	@Autowired
	private SearchService searchService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value= {"/home","/main","/"},method= {RequestMethod.GET, RequestMethod.POST})    
    public String getIndexPage(Model model,HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if (this.loginService.isValidSession(request)) {
			Student student=(Student)session.getAttribute("student");
			model.addAttribute("welcome", "Welcome! "+student.getFirst_name()+" "+student.getLast_name());
		}
        return "home";
    }
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String handleSearch(Model model, @ModelAttribute Student student, HttpServletRequest request) {
		String option=request.getParameterValues("option")[0];
		String query=request.getParameterValues("query")[0];
		List<Unit> unitmp=null;
		boolean uniflag=false;
		List<Lecturer> lectmp=null;
		boolean lectflag=false;
		if (option.equals("Units")) {
			unitmp=this.searchService.searchByUnitName(query);
			uniflag=true;
		}else if (option.equals("Lecturers")) {
			lectmp=this.searchService.searchByLecturerName(query);
			lectflag=true;
		}else if (option.equals("unicode")) {
			unitmp=this.searchService.searchByUnitCode(query);
			uniflag=true;
		}else {
			//normally we wouldn't hit this unless someone is intercepting and tempering the packet
			return "redirect:/search";
		}
		if (uniflag && !unitmp.isEmpty()) {
			model.addAttribute("isUnit",true);
			model.addAttribute("results",unitmp);
		}else if (lectflag && !lectmp.isEmpty()) {
			model.addAttribute("isLect", true);
			model.addAttribute("results", lectmp);
		}else {
			model.addAttribute("results", new ArrayList<Object>());
		}
		return "/searchResult";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String getSearchPage(Model model, HttpServletRequest request) {
		if (this.loginService.isValidSession(request)) {
			Student student=(Student) request.getSession().getAttribute("student");
        	model.addAttribute("welcome", student.getFirst_name()+" "+student.getLast_name());
        }
		return "search";
	}
	
}