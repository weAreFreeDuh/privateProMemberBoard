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
	
	// 프로젝트 홈페이지
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index1() {

		return "index";
	}

	// mJoinForm : 회원가입 페이지
	@RequestMapping(value = "/mJoinForm", method = RequestMethod.GET)
	public String mJoinForm() {

		return "M_Join";
	}

	// CheckId : 아이디 중복확인
	@RequestMapping(value = "/CheckId", method = RequestMethod.GET)
	public ModelAndView CheckId(@RequestParam("memId") String memId) {

		System.out.println("[1] jsp > controller 변수 : " + memId);
		mav = msvc.CheckId(memId);
		System.out.println("[5] controller < service  ");

		return mav;
	}

	// mJoin : 회원가입
	@RequestMapping(value = "/mJoin", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[1] jsp > controller 변수 : " + member);
		mav = msvc.mJoin(member);
		System.out.println("[5] controller < service  ");

		return mav;
	}

	// mLoginForm : 로그인 페이지
	@RequestMapping(value = "/mLoginForm", method = RequestMethod.GET)
	public String mLoginForm() {

		return "M_Login";
	}

	// mLogin : 로그인
	@RequestMapping(value = "/mLogin", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[1] jsp > controller 변수 : " + member);
		mav.setViewName("M_Join");
		mav = msvc.mLogin(member);
		System.out.println("[5] controller < service  ");

		return mav;
	}


	// 로그아웃
	@RequestMapping(value = "/mLogout", method = RequestMethod.GET)
	public String mLogout() {
		session.invalidate();
		return "index";
	}

	// mList : 회원목록(페이징)
	@RequestMapping(value = "/mList", method = RequestMethod.GET)
	public ModelAndView mList(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		mav = msvc.mList(page);
		return mav;
	}
	
	// mSearch : 회원검색
	@RequestMapping(value = "/mSearch", method = RequestMethod.GET)
	public ModelAndView mSearch(@ModelAttribute SEARCH search) {
		mav = msvc.mSearch(search);
		return mav;
	}
	// mView : 상세보기
	@RequestMapping(value = "/mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("memId") String memId) {
		mav = msvc.mView(memId);
		return mav;
	}
	
	// mModifyForm : 수정페이지
	@RequestMapping(value = "/mModifyForm", method = RequestMethod.GET)
	public ModelAndView mModifyForm(@RequestParam("memId") String memId) {
		mav = msvc.mModifyForm(memId);
		return mav;
	}
	// mModify : 회원수정
	@RequestMapping(value = "/mModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[1] jsp > controller 변수 : " + member);
		mav = msvc.mModify(member);
		System.out.println("[5] controller < service  ");

		return mav;
	}
	// mDelete
	@RequestMapping(value = "/mDelete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("memId") String memId) {

		System.out.println("[1] jsp > controller 변수 : " + memId);
		mav = msvc.mDelete(memId);
		System.out.println("[5] controller < service  ");

		return mav;
	}
	
	// idoverlap : 아이디 중복체크 ajax
	@RequestMapping(value = "/idoverlap", method = RequestMethod.POST)
	public @ResponseBody String idoverlap(@RequestParam("memId") String memId) {
		System.out.println("ajax로 넘오온 memId : "+ memId);

		String result = msvc.idoverlap(memId);
		System.out.println("db에서 확인 한 result : "+result);
		
		return result;
	}
	

	// mCheckEmail : 이메일 인증
	@RequestMapping(value = "/mCheckEmail", method = RequestMethod.POST)
	public @ResponseBody String mCheckEmail(@RequestParam("memEmail") String memEmail) {
		String uuid = msvc.mCheckEmail(memEmail);
		return uuid;
	}
	////////////////////////////////////////////////////////////
	
	// 테스트
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2() {

		return "index2";
	}
		
	// M_Login.jsp : 로그인 페이지
	@RequestMapping(value = "/M_Login", method = RequestMethod.GET)
	public String pages_login() {

		return "M_Login";
	}
	// M_register.jsp : 회원가입 페이지
	@RequestMapping(value = "/M_register", method = RequestMethod.GET)
	public String M_register() {

		return "M_register";
	}
	
	// mProfile : 자기프로필 확인
	@RequestMapping(value = "/mProfile", method = RequestMethod.GET)
	public String mProfile() {

		return "M_profile";
	}
	
	// mChangePw :비밀번호 변경
	@RequestMapping(value = "/mChangePw", method = RequestMethod.POST)
	public ModelAndView mChangePw(@ModelAttribute MEMBER member) {
		mav = msvc.mChangePw(member);
		
		return mav;
	}
	
}
