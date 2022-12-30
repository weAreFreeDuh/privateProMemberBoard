package com.icia.pro.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.pro.dto.BOARD;
import com.icia.pro.dto.PAGE;
import com.icia.pro.dto.SEARCH;

@Repository
public class BDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	// 게시글작성 페이지로 가기 위한 작성자 값 가져오기
	public String bWriteForm(String memId) {
		
		return sql.selectOne("Board.bWriteForm",memId);
	}

	public int bWrite(BOARD board) {	
		return sql.insert("Board.bWrite",board);
	}

	public int bCount() {
		return sql.selectOne("Board.bCount");
	}

	public List<BOARD> bList(PAGE paging) {
		return sql.selectList("Board.bList",paging);
	}

	public List<BOARD> bSearch(SEARCH search) {
		return sql.selectList("Board.mSearch",search);	
	}

	public BOARD bView(BOARD board) {
		sql.update("Board.bHit",board);
		return sql.selectOne("Board.bView",board);
	}

	public int bModify(BOARD board) {
		return sql.update("Board.bModify",board);
	}

	public int bDelete(int boNum) {
		sql.delete("Board.bDeleteComment",boNum);
		// 댓글 삭제
		return sql.delete("Board.bDelete",boNum);
	}



}
