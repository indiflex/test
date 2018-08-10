package com.tje.iot.persistence;

import com.tje.iot.domain.Member;

public interface MemberDAO {

	public String getTime();

	public void insertMember(Member member);
	
	public Member readMember(String userid) throws Exception;
}
