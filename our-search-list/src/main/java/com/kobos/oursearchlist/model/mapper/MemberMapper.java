package com.kobos.oursearchlist.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kobos.oursearchlist.model.vo.Authority;
import com.kobos.oursearchlist.model.vo.MemberVO;

@Mapper
public interface MemberMapper {
	MemberVO findMemberById(String id);

	int getTotalMemberCount();

	void registerMember(MemberVO memberVO);

	void registerRole(Authority authority);

	void updateMember(MemberVO memberVO);

	int idcheck(String id);

	List<Authority> selectAuthorityByUsername(String username);

}