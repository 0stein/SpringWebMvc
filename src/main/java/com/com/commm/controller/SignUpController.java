package com.com.commm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.com.commm.command.Member;
import com.com.commm.service.MemberAuthService;
import com.com.commm.service.MemberCURDService;

@Controller
@RequestMapping("signup")
public class SignUpController {
	
	@Autowired
	MemberCURDService memberCRUDService;
	@Autowired
	MemberAuthService memberAuthServcie;
	
	@RequestMapping(method = RequestMethod.GET)
	public String signupPage() {
		return "signup";
	}
	
	@ModelAttribute
	public Member setMemberAttribute() {
		return new Member();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String signupProcess(Model model, @Valid Member member, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		if(memberAuthServcie.IsExist(member.getId())) {
			model.addAttribute("errorMessage", "이미 존재하는 ID입니다. 다른 ID를 사용해 주세요.");
			return "signup";
		}
		memberCRUDService.addMember(member);
		return "login";
	}
}
