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
public class LoginController {
	@Autowired
	private LoginService loginService;
	// workload for genreating bcrypt hash
	private static int WORKLOAD=12;
	
    @GetMapping("/login")
    public String getLoginPage() {
    	return "login";
    }
  
    @PostMapping("/login")
    public String userLogin(HttpServletRequest request, Model model) {
    	String username=request.getParameterValues("username")[0];
    	String password=request.getParameterValues("password")[0];
    	Student student=this.loginService.userLogin(username, password);
    	// login success otherwise s is null
    	if (student instanceof Student) {
    		//grant session
    		HttpSession session=request.getSession(true);
    		session.setAttribute("loggedin", true);
    		session.setAttribute("student", student);
    		session.setMaxInactiveInterval(300);
    		//login success. Return relative information
            return "forward:/dashboard/";
    	}
    	model.addAttribute("error", "Wrong username or password :(");
    	return "login";
    }
    
    @GetMapping("/registration")
    public String getRegistrationPage() {  	
    	return "registration";
    }
    
    @PostMapping("/registration")
    public String register(
    		@ModelAttribute Student student, 
    		Model model,
    		HttpServletRequest request) {
    	// possible DDoS here... fix it at later time
    	String salt=BCrypt.gensalt(WORKLOAD);
    	// only store hashed password
    	// Password are hashed when registration. But those in data.sql are not hashed
    	student.setPassword(BCrypt.hashpw(student.getPassword(), salt));
    	Student addedStudent=this.loginService.insertStudent(student);
    	if (addedStudent.getId()==-1) {
    		//register fail for existing email
    		model.addAttribute("registerFailed", true);
    		return "registration";
    	}else {
    		HttpSession session=request.getSession(true);
    		session.setAttribute("loggedin", true);
    		session.setAttribute("student", student);
    		session.setMaxInactiveInterval(300);
        	model.addAttribute("student", addedStudent);
    	}
    	return "dashboard";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
    	request.getSession().invalidate();
    	model.addAttribute("error", "You've signed out");
    	return "home";
    }
}