package com.com.commm.service;

import java.util.List;

import com.com.commm.command.Member;

public interface MemberCURDService {
	void addMember(Member member);
	Member selectMember(String id);
	List<Member> selectAll();
}
