package com.com.commm.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.com.commm.command.Member;
import com.com.commm.command.MemberValidator;

@Controller
@RequestMapping("/main")
public class loginController {
	
	@ModelAttribute
	public Member settingMember() {
		return new Member();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String mainpage() {
		return "main";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute Member member , BindingResult bindingResult) {
		//new MemberValidator().validate(member, bindingResult); @Valid 와 @InitBinder가 자동으로 호출해준다.
		if(bindingResult.hasErrors()) {
			return "main";
		}
		System.out.println(member);
		return "info";
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberValidator());
	}
}
