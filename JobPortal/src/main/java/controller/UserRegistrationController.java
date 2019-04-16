package controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;

@Controller
public class UserRegistrationController {
	@Autowired
	public UserService userService;
	@RequestMapping(value="/userregister", method=RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("userregister");
		mav.addObject("user",new User());
		return mav;
	}
	@RequestMapping(value="/userregisterProcess", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute("user") User user)
	{
		userService.register(user);
		ModelAndView mav=new ModelAndView("userlogin");
		mav.addObject("message","registered succefully login to continue");
		return mav;
	}
}
