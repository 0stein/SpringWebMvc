package com.com.commm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.com.commm.command.Member;
import com.com.commm.service.MemberCURDService;

@Controller
public class MainPageController {
	
	@Autowired
	MemberCURDService memberCURDService;

	@RequestMapping(method = RequestMethod.GET)
	public String mainPage(Model model) {
		List<Member> list = memberCURDService.selectAll();
		model.addAttribute("MemberList", list);
		return "welcome";
	}
}
