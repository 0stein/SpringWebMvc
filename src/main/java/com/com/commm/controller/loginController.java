package com.com.commm.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.com.commm.command.Member;

@Controller
@RequestMapping("/main")
public class loginController {
	String uploadPath = "C:\\Users\\aad33\\multipart";
	
	@ModelAttribute
	public Member settingMember() {
		return new Member();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String mainpage() {
		return "main";
	}
	
	@RequestMapping("/info")
	public ModelAndView infopage(HttpServletRequest httpServletRequest) {
		Member member = (Member) httpServletRequest.getAttribute("member");
		ModelAndView moa = new ModelAndView();
		moa.setViewName("info");
		moa.addObject("member",member);
		return moa;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(
			@Valid @ModelAttribute Member member , BindingResult bindingResult
			,HttpServletRequest httpServletRequest) {
		//new MemberValidator().validate(member, bindingResult); @Valid 와 @InitBinder가 자동으로 호출해준다.
		if(bindingResult.hasErrors()) {
			return "main";
		}
		//session 설정
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("member", member);
	
		return "redirect:main/info";
	}
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new MemberValidator());
//	}
	
	
	//jackson-databind json-parser
	@RequestMapping(value="/info/data")
	@ResponseBody
	public Member jsonmember(HttpServletRequest request) {
		Member member = (Member)request.getSession().getAttribute("member");
		request.getSession().invalidate();
		return member;
	}
	
	//파일 업로드 방법 1 requestParam을 통해 전달받기.
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String getMultipart(@RequestParam("f") MultipartFile multipartFile, @RequestParam("title") String title, Model model) throws IOException {
		if(!multipartFile.isEmpty()) {
			byte[] bytes = multipartFile.getBytes();
			File file = new File(uploadPath, multipartFile.getOriginalFilename());
			FileCopyUtils.copy(bytes, file);
			model.addAttribute("title", title);
			model.addAttribute("fileName",multipartFile.getOriginalFilename());
			model.addAttribute("uploadPath", file.getAbsolutePath());
		}
		
		return "checkUploadFile";
	}
	
	//파일 업로드 방법 2
	// public String ***(MultipartHttpServletRequest request)
	// MultipartFile multipartFIle = request.getFile("f");
	
	//파일 업로드 방법 3
	// 커맨드 객체 사용.
}
