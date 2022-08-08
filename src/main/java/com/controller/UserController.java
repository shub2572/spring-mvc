package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.Dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/listUsers")
	public String getAllUsers(Model model) {

		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users", users);

		return "listUser";

	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId, Model model) {

		userDao.deleteUser(userId);
		return "redirect:/listUsers";

	}

	@GetMapping("/viewuser")
	public String viewUser(@RequestParam("userId") int userId, Model model) {
		UserBean user = userDao.getUserByUserId(userId);
		model.addAttribute("user", user);
		return "ViewUser";
	}

	@GetMapping("/searchUser")
	public String searchUser(@RequestParam("firstName") UserBean firstName, Model model) {
		UserBean user = userDao.searchUserByFirstName(firstName);
		model.addAttribute("firstName", firstName);
		return "SearchUser";
	}

	@GetMapping("/edituser")
	public String editUser(@RequestParam("userId") int userId, Model model) {
		UserBean user = userDao.getUserByUserId(userId);
		model.addAttribute("user", user);
		return "EditUser";
	}
	@PostMapping("/updateuser")
	public String updateUser(UserBean user) {
		userDao.updateUser(user);
		return "redirect:/listUsers";
	}
}
