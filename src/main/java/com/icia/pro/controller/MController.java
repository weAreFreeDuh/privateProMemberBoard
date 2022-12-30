package com.icia.pro.controller;

import java.io.IOException;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.pro.dto.MEMBER;
import com.icia.pro.dto.SEARCH;
import com.icia.pro.service.MService;

@Controller
public class MController {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private MService msvc;

	@Autowired
	private HttpSession session;
	
	// ������Ʈ Ȩ������
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index1() {

		return "index";
	}

	// mJoinForm : ȸ������ ������
	@RequestMapping(value = "/mJoinForm", method = RequestMethod.GET)
	public String mJoinForm() {

		return "M_Join";
	}

	// CheckId : ���̵� �ߺ�Ȯ��
	@RequestMapping(value = "/CheckId", method = RequestMethod.GET)
	public ModelAndView CheckId(@RequestParam("memId") String memId) {

		System.out.println("[1] jsp > controller ���� : " + memId);
		mav = msvc.CheckId(memId);
		System.out.println("[5] controller < service  ");

		return mav;
	}

	// mJoin : ȸ������
	@RequestMapping(value = "/mJoin", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[1] jsp > controller ���� : " + member);
		mav = msvc.mJoin(member);
		System.out.println("[5] controller < service  ");

		return mav;
	}

	// mLoginForm : �α��� ������
	@RequestMapping(value = "/mLoginForm", method = RequestMethod.GET)
	public String mLoginForm() {

		return "M_Login";
	}

	// mLogin : �α���
	@RequestMapping(value = "/mLogin", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[1] jsp > controller ���� : " + member);
		mav.setViewName("M_Join");
		mav = msvc.mLogin(member);
		System.out.println("[5] controller < service  ");

		return mav;
	}


	// �α׾ƿ�
	@RequestMapping(value = "/mLogout", method = RequestMethod.GET)
	public String mLogout() {
		session.invalidate();
		return "index";
	}

	// mList : ȸ�����(����¡)
	@RequestMapping(value = "/mList", method = RequestMethod.GET)
	public ModelAndView mList(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		mav = msvc.mList(page);
		return mav;
	}
	
	// mSearch : ȸ���˻�
	@RequestMapping(value = "/mSearch", method = RequestMethod.GET)
	public ModelAndView mSearch(@ModelAttribute SEARCH search) {
		mav = msvc.mSearch(search);
		return mav;
	}
	// mView : �󼼺���
	@RequestMapping(value = "/mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("memId") String memId) {
		mav = msvc.mView(memId);
		return mav;
	}
	
	// mModifyForm : ����������
	@RequestMapping(value = "/mModifyForm", method = RequestMethod.GET)
	public ModelAndView mModifyForm(@RequestParam("memId") String memId) {
		mav = msvc.mModifyForm(memId);
		return mav;
	}
	// mModify : ȸ������
	@RequestMapping(value = "/mModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[1] jsp > controller ���� : " + member);
		mav = msvc.mModify(member);
		System.out.println("[5] controller < service  ");

		return mav;
	}
	// mDelete
	@RequestMapping(value = "/mDelete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("memId") String memId) {

		System.out.println("[1] jsp > controller ���� : " + memId);
		mav = msvc.mDelete(memId);
		System.out.println("[5] controller < service  ");

		return mav;
	}
	
	// idoverlap : ���̵� �ߺ�üũ ajax
	@RequestMapping(value = "/idoverlap", method = RequestMethod.POST)
	public @ResponseBody String idoverlap(@RequestParam("memId") String memId) {
		System.out.println("ajax�� �ѿ��� memId : "+ memId);

		String result = msvc.idoverlap(memId);
		System.out.println("db���� Ȯ�� �� result : "+result);
		
		return result;
	}
	

	// mCheckEmail : �̸��� ����
	@RequestMapping(value = "/mCheckEmail", method = RequestMethod.POST)
	public @ResponseBody String mCheckEmail(@RequestParam("memEmail") String memEmail) {
		String uuid = msvc.mCheckEmail(memEmail);
		return uuid;
	}
	////////////////////////////////////////////////////////////
	
	// �׽�Ʈ
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2() {

		return "index2";
	}
		
	// M_Login.jsp : �α��� ������
	@RequestMapping(value = "/M_Login", method = RequestMethod.GET)
	public String pages_login() {

		return "M_Login";
	}
	// M_register.jsp : ȸ������ ������
	@RequestMapping(value = "/M_register", method = RequestMethod.GET)
	public String M_register() {

		return "M_register";
	}
	
	// mProfile : �ڱ������� Ȯ��
	@RequestMapping(value = "/mProfile", method = RequestMethod.GET)
	public String mProfile() {

		return "M_profile";
	}
	
	// mChangePw :��й�ȣ ����
	@RequestMapping(value = "/mChangePw", method = RequestMethod.POST)
	public ModelAndView mChangePw(@ModelAttribute MEMBER member) {
		mav = msvc.mChangePw(member);
		
		return mav;
	}
	
}
