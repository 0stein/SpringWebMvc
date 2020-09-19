package com.com.commm.percistence;

import java.util.List;

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
	private static final String SelectAll = "config.Member.selectAll";
	
	@Override
	public void insertMember(Member member) {
		sqlsession.insert(InsertMember, member);
	}

	@Override
	public Member selectMember(String id) {
		return (Member)sqlsession.selectOne(SelectMember, id);
	}

	@Override
	public List<Member> selectALL() {
		return sqlsession.selectList(SelectAll);
	}

	
}
