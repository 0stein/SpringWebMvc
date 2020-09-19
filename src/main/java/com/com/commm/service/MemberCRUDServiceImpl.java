package com.com.commm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.commm.command.Member;
import com.com.commm.percistence.MemberDao;

@Service
public class MemberCRUDServiceImpl implements MemberCURDService{
	
	@Autowired
	MemberDao daoImpl;
	
	private Member hobbyToHobbyString(Member member) {
		String hobbyString="";
		for(String h : member.getHobby()) {
			hobbyString += h+";";
		}
		member.setHobbyString(hobbyString);
		return member;
	}
	
	private Member hobbyStringToHobby(Member member) {
		String[] hobby = member.getHobbyString().split(";");
		member.setHobby(hobby);
		return member;
	}
	
	@Override
	public void addMember(Member member) {
		if(member.getHobby()!= null) {			
			hobbyToHobbyString(member);
		}
		daoImpl.insertMember(member);
	}
	
	@Override
	public Member selectMember(String id) {
		Member member = daoImpl.selectMember(id);
		if(member.getHobbyString()!= null) {
			hobbyStringToHobby(member);
		}
		return member;
	}

	@Override
	public List<Member> selectAll() {
		return daoImpl.selectALL();
	}
	
	
}
