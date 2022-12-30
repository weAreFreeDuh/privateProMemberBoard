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

	// �ƾƵ� �ߺ�üũ
	public String CheckId(String memId) {
		System.out.println("[3] service -> dao ���� : " + memId);
		return sql.selectOne("Member.CheckId", memId);
	}

	// ȸ������
	public int mJoin(MEMBER member) {
		System.out.println("[3] service -> dao ���� : " + member);
		return sql.insert("Member.mJoin", member);
	}

	// �α���
	public String mLogin(MEMBER member) {
		System.out.println("[3] service -> dao ���� : " + member);
		return sql.selectOne("Member.mLogin", member);
	}
	// �α��� �� ���� ��������
	public MEMBER mInfo(MEMBER member) {
		System.out.println("[3] service -> dao ���� : " + member);
		return sql.selectOne("Member.mInfo",member);
	}
	
//	public int emailCheck(MEMBER member) {
//		return sql.update("Member.emailCheck", member);
//	}

//	public List<Member> mList() {
//		System.out.println("[3] service -> dao ���� : ");
//		return sql.selectList("Member.mList");
//	}
	
	//����¡
	public List<MEMBER> mList(PAGE paging) {
		return sql.selectList("Member.mList", paging);
	}
	
	//ī��Ʈ
	public int mCount() {
		return sql.selectOne("Member.mCount");
	}
	
	//ȸ���˻�
	public List<MEMBER> mSearch(SEARCH search) {
		System.out.println("[3] service -> dao ���� : " + search);
			return sql.selectList("Member.mSearch",search);
	}
	// �󼼺���
	public MEMBER mView(String memId) {
		System.out.println("[3] service -> dao ���� : " + memId);
		return sql.selectOne("Member.mView",memId);
	}
	// ȸ������
	public int mModify(MEMBER member) {
		System.out.println("[3] service -> dao ���� : " + member);
		return sql.update("Member.mModify",member);
	}
	// ȸ������
	public int mDelete(String memId) {
		
		return sql.delete("Member.mDelete",memId);
	}

	////////////////////////////////////////////////////////////////////////////////////
	
	// ��й�ȣ ����
	public int mChangePw(MEMBER member) {
		
		return sql.update("Member.mChangePw",member);
	}

}
