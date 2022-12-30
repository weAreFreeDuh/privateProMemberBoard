package com.icia.pro.controller;

import java.io.IOException;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.pro.dto.BOARD;
import com.icia.pro.dto.SEARCH;
import com.icia.pro.service.BService;

@Controller
public class BController {
	
	private ModelAndView mav = new ModelAndView();

	@Autowired
	private BService bsvc;

	@Autowired
	private HttpSession session;
	
	// bWriteForm : ȸ���� �Խñ� ������
	@RequestMapping(value = "/bWriteForm", method = RequestMethod.GET)
	public ModelAndView bWriteForm(@RequestParam("memId")String memId) {
		
		ModelAndView mav =  bsvc.bWriteForm(memId);
		return mav;
	}
	
	// bWrite : ȸ���� �Խñ� �ۼ�
	@RequestMapping(value = "/bWrite", method = RequestMethod.POST)
	public ModelAndView bWrite(@ModelAttribute BOARD board) throws IllegalStateException, IOException {
		
		ModelAndView mav =  bsvc.bWrite(board);
		
		return mav;
	}
	
	// bList : �Խñ� ���
	@RequestMapping(value = "/bList", method = RequestMethod.GET)
	public ModelAndView bList(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		mav = bsvc.bList(page);
		return mav;
	}
	
	// bSearch : �˻����
	@RequestMapping(value = "/bSearch", method = RequestMethod.GET)
	public ModelAndView mSearch(@ModelAttribute SEARCH Search) {
		mav = bsvc.bSearch(Search);
		return mav;
	}
	
	// bView : �Խñ� �󼼺���
	@RequestMapping(value = "/bView", method = RequestMethod.GET)
	public ModelAndView bView(@ModelAttribute BOARD board) {
		mav = bsvc.bView(board);
		return mav;
	}
	
	// bModifyForm : �Խñ� ����������
	@RequestMapping(value = "/bModifyForm", method = RequestMethod.GET)
	public ModelAndView bModifyForm(@ModelAttribute BOARD board) {
		mav = bsvc.bModifyForm(board);
		return mav;
	}
	// bModify : �����ϱ�
	@RequestMapping(value = "/bModify", method = RequestMethod.POST)
	public ModelAndView bModify(@ModelAttribute BOARD board) throws IllegalStateException, IOException {
		mav = bsvc.bModify(board);
		return mav;
	}
	
	// bDelete : �Խñ� ����
	@RequestMapping(value = "/bDelete", method = RequestMethod.GET)
	public ModelAndView bDelete(@RequestParam("boNum")int boNum) {
		mav = bsvc.bDelete(boNum);
		return mav;
	}
	
	
	
	////////////////////////////////////////////////////////////
	
	// forms-editors.html
	@RequestMapping(value = "/forms-editors", method = RequestMethod.GET)
	public String forms_editors() {

		return "forms-editors";
	}
	
	// forms-elements.html
	@RequestMapping(value = "/forms-elements", method = RequestMethod.GET)
	public String forms_elements() {

		return "forms-elements";
	}
	
	// write : �ۼ� ������
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {

		return "B_Write";
	}
	
	// ������������ �Խñ��� �ҷ����� ���� ����
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView bListhoe(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		System.out.println(page);
		mav = bsvc.bList(page);
		return mav;
	}
	
	// �Խñ� ���� ����Ʈ
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String view() {

		return "B_View";
	}
	

	
}
