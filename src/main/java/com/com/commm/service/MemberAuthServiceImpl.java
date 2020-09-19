package com.com.commm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.commm.command.Member;
import com.com.commm.percistence.MemberDao;

@Service
public class MemberAuthServiceImpl implements MemberAuthService{

	@Autowired
	MemberDao dao;
	
	@Override
	public boolean IsExist(String id) {
		Member member = dao.selectMember(id);
		if(member!=null) {
			if(member.getId().equals(id)) {
				return true;
			}	
		}
		return false;
	}

	@Override
	public boolean IsMatchIDPW(String id, String password) {
		Member member = dao.selectMember(id);
		if(member.getPassword().equals(password)) {
			System.out.println("member.getPassword : "+member.getPassword());
			System.out.println("member : "+password);
			return true;
		}
		return false;
	}
}
