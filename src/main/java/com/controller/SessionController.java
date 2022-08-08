package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dao.UserDao;
import com.bean.LoginBean;
import com.bean.UserBean;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(UserBean user, Model model) {
		model.addAttribute("user", user);
		return "signup";

	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid UserBean userBean, BindingResult result,
			Model model) {
		System.out.println(userBean.getFirstName());
		System.out.println(userBean.getLastName());
		System.out.println(userBean.getEmail());
		System.out.println(userBean.getPassword());

		if (result.hasErrors()) {
			model.addAttribute("user", userBean);
			return "signup";

		} else {
               
			userBean.setUserType("customer");
			 userDao.addUser(userBean);
			 model.addAttribute("msg","Signup done successfully...");
			return "Login";
		}
	}

	

	  @GetMapping("/login") 
	  public String login() { 
		  
		  return "Login"; }
	  
	  @PostMapping("/loginAuth") 
	  public String authenticate(LoginBean login,Model model,HttpSession session) {
		  UserBean user = userDao.authenticate(login);
		  
			if(user == null) {
				model.addAttribute("msg","InvalidCredentials");
				return "Login";
			}else if (user.getUserType().contentEquals("customer")) {
				session.setAttribute("user", user);
				return "home";
			} else if (user.getUserType().contentEquals("admin")) {
				session.setAttribute("user", user);
				return "AdminDashboard";
			} else {
				model.addAttribute("msg", "Please Contact Admin");
				return "Login";
			}
	 
	  }
	  @GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/login";
		}
}
