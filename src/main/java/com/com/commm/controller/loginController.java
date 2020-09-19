package com.com.commm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.com.commm.command.Member;
import com.com.commm.service.MemberAuthService;
import com.com.commm.service.MemberCURDService;

@Controller
@RequestMapping("/login")
public class loginController {
	
	@Autowired
	MemberCURDService memberCRUDService;
	@Autowired
	MemberAuthService memberAuthService;
	
	@ModelAttribute
	public Member setMemberAttribute() {
		return new Member();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginProcess(
			Model model,
			@RequestParam("id") String id, @RequestParam("password") String password) {
		if(id == null || password == null) {
			model.addAttribute("errorMessage", "id 또는 password를 입력하세요.");
			return "login";
		}
		if(!memberAuthService.IsExist(id)) {
			model.addAttribute("errorMessage", "id가 존재하지 않습니다.");
			return "login";
		}
		if(memberAuthService.IsMatchIDPW(id, password)) {
			return "redirect:/welcome";	
		}else {
			model.addAttribute("errorMessage", "password가 일치하지 않습니다.");
			return "login";
		}
	}
}
