package com.com.commm.percistence;

import com.com.commm.command.Member;

public interface MemberDao {
	public void insertMember(Member vo);
	public Member selectMember(String userid);
}
