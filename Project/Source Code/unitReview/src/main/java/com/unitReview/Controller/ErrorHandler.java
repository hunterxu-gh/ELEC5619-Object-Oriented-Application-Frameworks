package com.unitReview.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorHandler implements ErrorController  {
 
	@Override
    public String getErrorPath() {
        return "/error";
    }
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object outcomingstatus=request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (outcomingstatus != null) {
            Integer statusCode = Integer.valueOf(outcomingstatus.toString());
         
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	
                return "404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";
            }
        }
        return "error";
    }
 
    
}