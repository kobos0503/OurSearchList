package com.kobos.oursearchlist.model.service;

import java.util.List;

import com.kobos.oursearchlist.model.vo.Authority;
import com.kobos.oursearchlist.model.vo.MemberVO;

public interface MemberService {

	int getTotalMemberCount();

	void updateMember(MemberVO vo);

	void registerMember(MemberVO vo);

	String idcheck(String id);

	MemberVO findMemberById(String id);

	List<Authority> selectAuthorityByUsername(String username);

}
