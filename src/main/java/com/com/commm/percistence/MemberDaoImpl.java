package com.com.commm.percistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.com.commm.command.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Inject
	private SqlSession sqlsession;
	
	private static final String InsertMember = "config.Member.insertMember";
	private static final String SelectMember = "config.Member.selectMember";
	
	
	@Override
	public void insertMember(Member vo) {
		sqlsession.insert(InsertMember, vo);
	}

	@Override
	public Member selectMember(String name) {
		return (Member)sqlsession.selectOne(SelectMember,name);
	}
}
