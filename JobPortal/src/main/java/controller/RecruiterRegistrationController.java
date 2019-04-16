package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Recruiter;
import service.RecruiterService;


@Controller
public class RecruiterRegistrationController {
	@Autowired
	public RecruiterService recruiterService;
	@RequestMapping(value="/RecruiterRegister", method=RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("RecruiterRegister");
		mav.addObject("recruiter",new Recruiter());
		return mav;
	}
	@RequestMapping(value="/RecruiterRegisterProcess", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute("recruiter") Recruiter recruiter)
	{
		recruiterService.register(recruiter);
		ModelAndView mav=new ModelAndView("Recruiterlogin");
		mav.addObject("message","registered succefully login to continue");
		return mav;
	}
}