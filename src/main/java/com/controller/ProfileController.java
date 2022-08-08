package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Dao.ProfileDao;
import com.Dao.SecQueAnsDao;
import com.bean.ProfileBean;
import com.bean.SetQueAnsBean;
import com.bean.UserBean;
import com.services.FileUploadService;

@Controller
public class ProfileController {

	@Autowired
	SecQueAnsDao ansDao;

	@Autowired
	ProfileDao profileDao;

	@Autowired
	FileUploadService fileUploadService;

	@GetMapping("/setsecquestion")
	public String setSecQuestionAns(HttpSession session, Model model) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<SetQueAnsBean> allQuestions = ansDao.getQuestionByUser(user.getUserId());
		model.addAttribute("allQuestions", allQuestions);
		return "SetSecQuestionAns";
	}

	@PostMapping("/savequestionans")
	public String saveQuestionAns(SetQueAnsBean ansBean, HttpSession session, Model model) {

		UserBean user = (UserBean) session.getAttribute("user");
		ansBean.setUserId(user.getUserId());
		ansDao.addQuestion(ansBean);

		model.addAttribute("msg", "question added");
		return "Home";
	}

	@GetMapping("/newprofile")
	public String newProfile() {
		return "NewProfile";
	}

	@PostMapping("/saveprofiles")
	public String saveProfile(@RequestParam("profile") MultipartFile file , HttpSession session) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		UserBean user =  (UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		
		
		
		try {
	 		fileUploadService.imgUpload(file, userId);
			
			ProfileBean profileBean = new ProfileBean();	
			profileBean.setUserId(userId);
			profileBean.setImgUrl("resources/images/" + userId+ "/" + file.getOriginalFilename());
			profileBean.setActive(true);
			profileDao.addImg(profileBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	@GetMapping("/listallimages")
	public String getAllImages(HttpSession session ,Model model) {
		
		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		List<ProfileBean> profiles = profileDao.getAllImagesByUser(userId);
		model.addAttribute("profiles",profiles);
		
		return "ListProfilesimage";
		
		
	}

}
