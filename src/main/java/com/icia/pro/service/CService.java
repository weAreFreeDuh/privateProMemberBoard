package com.icia.pro.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.pro.dao.CDAO;
import com.icia.pro.dto.COMMENT;

@Service
public class CService {
	
	@Autowired
	private CDAO cdao;
	
	public List<COMMENT> cList(int cbNum) {
		System.out.println(cbNum);
		
		List<COMMENT> commentList = cdao.cList(cbNum);
		
		System.out.println(commentList);
		return commentList;
	}

	public List<COMMENT> cmtWrite(COMMENT comment) {
		
		List<COMMENT> commentList;
		System.out.println("cmtWrite"+comment);
		
		int result = cdao.cmtWrite(comment);
		
		if(result>0) {
			commentList = cdao.cList(comment.getCbNum());
		}else {
			commentList = null;
		}
		System.out.println("cmtWrite"+result);
		
		return commentList;
	}

	public List<COMMENT> cmtDelete(COMMENT comment) {
		List<COMMENT> commentList;
		System.out.println("cmtDelete"+comment);
		
		int result = cdao.cmtDelete(comment);
		
		if(result>0) {
			commentList = cdao.cList(comment.getCbNum());
		}else {
			commentList = null;
		}
		System.out.println("cmtDelete"+result);
		
		return commentList;
	}

	public List<COMMENT> cmtModify(COMMENT comment) {
		
		List<COMMENT> commentList;
		System.out.println("cmtModify"+comment);
		
		int result = cdao.cmtModify(comment);
		
		if(result>0) {
			commentList = cdao.cList(comment.getCbNum());
		}else {
			commentList = null;
		}
		System.out.println("cmtModify"+result);
		
		return commentList;
	}
	
	
	
	
	}


