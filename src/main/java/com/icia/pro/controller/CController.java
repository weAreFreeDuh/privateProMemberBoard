package com.icia.pro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.pro.dto.COMMENT;
import com.icia.pro.service.CService;

@Controller
@RequestMapping("/comment")
public class CController {

	@Autowired
	private CService csvc;
	
	// ¥Ò±€ ∫∏±‚
	@RequestMapping(value = "/cList", method = RequestMethod.POST)
	public @ResponseBody List<COMMENT> cList(@RequestParam("cbNum") int cbNum) {
		List<COMMENT> commentList = csvc.cList(cbNum);
		System.out.println(cbNum);
		return commentList;
	}
	
	// cmtWrite : ¥Ò±€ ¿€º∫
	@RequestMapping(value = "/cmtWrite", method = RequestMethod.POST)
	public @ResponseBody List<COMMENT> cmtWrite(@ModelAttribute COMMENT comment) {
		List<COMMENT> commentList = csvc.cmtWrite(comment);
		System.out.println("cmtWrite  "+comment);
		return commentList;
	}
	// cmtDelete : ¥Ò±€ ªË¡¶
	@RequestMapping(value = "/cmtDelete", method = RequestMethod.POST)
	public @ResponseBody List<COMMENT> cmtDelete(@ModelAttribute COMMENT comment) {
		List<COMMENT> commentList = csvc.cmtDelete(comment);
		System.out.println("cmtDelete  "+comment);
		return commentList;
	}
	
	// cmtModify : ¥Ò±€ ºˆ¡§
	@RequestMapping(value = "/cmtModify", method = RequestMethod.POST)
	public @ResponseBody List<COMMENT> cmtModify(@ModelAttribute COMMENT comment) {
		List<COMMENT> commentList = csvc.cmtModify(comment);
		System.out.println("cmtModify  "+comment);
		return commentList;
	}
	
}
