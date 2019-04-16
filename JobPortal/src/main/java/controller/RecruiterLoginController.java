package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.RecLogin;
import model.Recruiter;
import service.RecruiterService;

@Controller
public class RecruiterLoginController {
	@Autowired
	RecruiterService recruiterService;
	@RequestMapping(value="/Recruiterlogin", method=RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("Recruiterlogin");
		mav.addObject("reclogin",new RecLogin());
		return mav;
	}
	@RequestMapping(value="/RecruiterloginProcess", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute("Recruiterlogin") RecLogin reclogin)
	{
		ModelAndView mav=null;
		Recruiter recruiter=recruiterService.validateRecruiter(reclogin);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
		if(null !=recruiter)
		{
			System.out.println(reclogin.getPassword());
			System.out.println(recruiter.getPassword());
			if(encoder.matches(reclogin.getPassword(), recruiter.getPassword()))
			{
			mav=new ModelAndView("welcome");
			mav.addObject("message","welcome" + "" +recruiter.getCname());
			}
			else
			{
				mav= new ModelAndView("Recruiterlogin");
				mav.addObject("message","Password is wrong");
			}
		}
		else
		{
			mav= new ModelAndView("Recruiterlogin");
			mav.addObject("message","Username or Password is wrong");
		}
	
		return mav;
		
	}

}
