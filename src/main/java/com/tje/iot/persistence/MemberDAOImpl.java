package com.tje.iot.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tje.iot.domain.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
//	private static final String NS = "com.tje.iot.mapper.MemberMapper";
	
	private static final String GetTime = "MemberMapper.getTime";
	private static final String InsertMember = "MemberMapper.insertMember";
	private static final String SelectMember = "MemberMapper.selectMember";

	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
	}

	@Override
	public void insertMember(Member member) {
		sqlSession.insert(InsertMember, member);
	}

	@Override
	public Member readMember(String userid) throws Exception {
		return sqlSession.selectOne(SelectMember, userid);
	}
	
}
