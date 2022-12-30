package com.icia.pro.dao;

import java.lang.reflect.Member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.pro.dto.MEMBER;
import com.icia.pro.dto.PAGE;
import com.icia.pro.dto.SEARCH;

@Repository
public class MDAO {

	@Autowired
	private SqlSessionTemplate sql;

	// 아아디 중복체크
	public String CheckId(String memId) {
		System.out.println("[3] service -> dao 변수 : " + memId);
		return sql.selectOne("Member.CheckId", memId);
	}

	// 회원가입
	public int mJoin(MEMBER member) {
		System.out.println("[3] service -> dao 변수 : " + member);
		return sql.insert("Member.mJoin", member);
	}

	// 로그인
	public String mLogin(MEMBER member) {
		System.out.println("[3] service -> dao 변수 : " + member);
		return sql.selectOne("Member.mLogin", member);
	}
	// 로그인 시 정보 가져오기
	public MEMBER mInfo(MEMBER member) {
		System.out.println("[3] service -> dao 변수 : " + member);
		return sql.selectOne("Member.mInfo",member);
	}
	
//	public int emailCheck(MEMBER member) {
//		return sql.update("Member.emailCheck", member);
//	}

//	public List<Member> mList() {
//		System.out.println("[3] service -> dao 변수 : ");
//		return sql.selectList("Member.mList");
//	}
	
	//페이징
	public List<MEMBER> mList(PAGE paging) {
		return sql.selectList("Member.mList", paging);
	}
	
	//카운트
	public int mCount() {
		return sql.selectOne("Member.mCount");
	}
	
	//회원검색
	public List<MEMBER> mSearch(SEARCH search) {
		System.out.println("[3] service -> dao 변수 : " + search);
			return sql.selectList("Member.mSearch",search);
	}
	// 상세보기
	public MEMBER mView(String memId) {
		System.out.println("[3] service -> dao 변수 : " + memId);
		return sql.selectOne("Member.mView",memId);
	}
	// 회원수정
	public int mModify(MEMBER member) {
		System.out.println("[3] service -> dao 변수 : " + member);
		return sql.update("Member.mModify",member);
	}
	// 회원삭제
	public int mDelete(String memId) {
		
		return sql.delete("Member.mDelete",memId);
	}

	////////////////////////////////////////////////////////////////////////////////////
	
	// 비밀번호 변경
	public int mChangePw(MEMBER member) {
		
		return sql.update("Member.mChangePw",member);
	}

}
