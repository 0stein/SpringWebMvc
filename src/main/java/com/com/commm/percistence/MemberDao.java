package com.com.commm.percistence;

import java.util.List;

import com.com.commm.command.Member;

public interface MemberDao {
	public void insertMember(Member member);
	public Member selectMember(String id);
	public List<Member> selectALL();
}
