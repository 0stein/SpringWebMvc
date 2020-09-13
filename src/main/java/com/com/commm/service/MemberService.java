package com.com.commm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.commm.command.Member;
import com.com.commm.percistence.MemberDaoImpl;

@Service
public class MemberService {
	
	@Autowired
	MemberDaoImpl daoImpl;
	
	public void addMember(Member member) {
		if(member.getHobby()!= null) {
			String hobbyString="";
			for(String h : member.getHobby()) {
				hobbyString += h+";";
			}
			member.setHobbyString(hobbyString);			
		}
		
		daoImpl.insertMember(member);
	}
	
	public Member selectMember(String name) {
		Member member = daoImpl.selectMember(name);
		if(member.getHobbyString()!= null) {
			String[] hobby = member.getHobbyString().split(";");
			member.setHobby(hobby);
		}
		return member;
	}
}
