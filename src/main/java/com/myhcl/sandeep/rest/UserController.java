package com.myhcl.sandeep.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myhcl.sandeep.entity.User;
import com.myhcl.sandeep.service.IUserService;
import com.myhcl.sandeep.util.CaptchaUtil;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService usrService;
	
	private void setupCaptcha(User user) {
		Captcha captcha=CaptchaUtil.createCaptcha(280, 80);
		user.setHidden(captcha.getAnswer());
		user.setCaptcha(null);//user entered value
		user.setImage(CaptchaUtil.encodeBase64(captcha));//captcha image
	}
	
	@GetMapping("/show")
	public String showReg(Model model) {
		User user=new User();
		setupCaptcha(user);
		model.addAttribute("user", user);
		return "RegisterPage";
	}
	
	@PostMapping("/save")
	public String regUser(@ModelAttribute User user,Model model) {
		String message=null;
		if(user.getCaptcha().equals(user.getHidden())) {
			Integer id=usrService.createUser(user);
			message="User Created :"+id;
		}else {
			message="Invaild Captcha";
			setupCaptcha(user);
			model.addAttribute("user", user);
		}
		
		model.addAttribute("message", message);
		return "RegisterPage";
		
	}
	

}
