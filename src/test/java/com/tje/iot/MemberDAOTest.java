package com.tje.iot;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tje.iot.domain.Member;
import com.tje.iot.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testGetTime() {
		System.out.println("Time is " + dao.getTime());
	}

	@Test
	public void testInsertMember() {
		Member member = new Member();
//		member.setUserid("user" + System.currentTimeMillis());
		member.setUserid("user00");
		member.setUserpw("user00pw");
		member.setUsername("홍길동00");
		member.setEmail("user00@aaa.com");
		
		dao.insertMember(member);
	}
	
	@Test
	public void testSelectMember() throws Exception {
		Member member = dao.readMember("user00");
		System.out.println("----------------------------\n" + member);
	}

}
