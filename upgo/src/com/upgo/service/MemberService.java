
 package com.upgo.service;

import com.upgo.dao.MemberDao;
import com.upgo.dto.Member;

public class MemberService {

	public void registerMember(Member member) {
		//처리해야할 내용이 있는 경우 구현 ...
		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

	public Member authenticate(String memberId, String passwd) {
		MemberDao dao = new MemberDao();
		Member member = dao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
	}

	
	public void updateMember(Member member) {
		MemberDao memberDao = new MemberDao();
		memberDao.updateMember(member);
	
	}

	public void deleteMember(Member member) {
		MemberDao memberDao = new MemberDao();
		memberDao.deleteMember(member);
		
	}

	public Member findpasswd(String memberId, String email) {
		MemberDao dao = new MemberDao();
		Member member = dao.findMyPasswd(memberId, email);
		return member;
	}

	public void newpasswd(Member member) {
		MemberDao memberDao = new MemberDao();
		memberDao.newPassword(member);
		
	}

	
}
