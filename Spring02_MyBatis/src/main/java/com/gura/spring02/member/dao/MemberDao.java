package com.gura.spring02.member.dao;

import java.util.List;

import com.gura.spring02.member.dto.MemberDto;
/*
 *  의존 관계를 느슨하게 하기 위해 Dao 클래스가 구현할 인터페이스를 미리 정의한다. 
 */
public interface MemberDao {
	public List<MemberDto> getList();
	public void insert(MemberDto dto);
	public void delete(int num);
	public MemberDto getData(int num);
	public void update(MemberDto dto);
}
