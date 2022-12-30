package com.icia.pro.service;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.pro.dao.MDAO;
import com.icia.pro.dto.MEMBER;
import com.icia.pro.dto.PAGE;
import com.icia.pro.dto.SEARCH;

@Service
public class MService {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private MDAO mdao;

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private BCryptPasswordEncoder pwEnc;

	@Autowired
	private JavaMailSender mailSender;

	private final static String mSalt = "코스";

	public static String encodeSha256(String source) {
		String result = "";

		byte[] a = source.getBytes();
		byte[] salt = mSalt.getBytes();
		byte[] bytes = new byte[a.length + salt.length];

		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);

			byte[] byteData = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}

			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 아이디 중복확인
	public ModelAndView CheckId(String memId) {

		System.out.println("[2] controller > service 변수 : " + memId);
		String CheckId = mdao.CheckId(memId);
		System.out.println("[4] service < dao 변수 : " + CheckId);
		if (CheckId == null) {
			// 아아디 사용가능
			mav.setViewName("M_Join1");
			mav.addObject("CheckId", memId);
		} else {
			// 이미 사용중인 아이디
			mav.setViewName("M_Join2");
			mav.addObject("CheckId", memId);
		}

		return mav;
	}

	// 회원가입
	public ModelAndView mJoin(MEMBER member) throws IllegalStateException, IOException {

		// 암호화
//		String Sha = encodeSha256(member.getMemPw()).substring(0, 16)
//				+ encodeSha256(member.getMemId()).substring(0, 16);
//		member.setMemPw(Sha);
//		System.out.println("비밀번호 암호화 : " + member.getMemPw());

		// [1] 파일 업로드
		// - 파일 이름 생성
		// - (식별자 uuid + 파일이름)
		// - profile폴더 생성 후 업로드
		// (1) 파일정보 가져오기
		System.out.println("[2] controller > service 변수 : " + member);
		MultipartFile memProfile = member.getMemProfile();

		// (2) 파일이름 설정하기
		UUID uuid = UUID.randomUUID();

		System.out.println("uuid 확인 : " + uuid.toString().substring(0, 8));

		// 만약에 업로드 파일이 없다면
		if (memProfile != null) {

			// 랜던한 식별문자 uuid.toString().subString(0,8)과 실제 파일이름을 합친 것
			String memProfileName = uuid.toString().substring(0, 8) + "_" + memProfile.getOriginalFilename();

			// member 객체에 생성한 파일이름을 업로드한 파일 이름을 저장한다
			member.setMemProfileName(memProfileName);

			// 저장 경로(절대 경로)에 파일을 업로드한다.
			// String savePath =
			// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
			// 상대 경로로 서버에 업로드
			String savePath = request.getSession().getServletContext().getRealPath("/resources/profile/");

			memProfile.transferTo(new File(savePath + memProfileName));
		}

		// [2] 주소 결합
		// - (addr1) + addr2 + addr3
		// ex) (22223) 인천 미추홀구 매소홀로 488번길 6-32, 태승빌딩 4층 // 과 같이 출력
		// - setter 사용해서 memAddr에 저장하기
		String addr1 = member.getAddr1();
		String addr2 = member.getAddr2();
		String addr3 = member.getAddr3();

		String memAddr = "(" + addr1 + ") " + addr2 + ", " + addr3;
		member.setMemAddr(memAddr);

		// 비밀번호 암호화
		member.setMemPw(pwEnc.encode(member.getMemPw()));

		// 가입
		System.out.println("[4] service < dao 변수 : " + member);
		int result = mdao.mJoin(member);

		if (result > 0) {
			mav.setViewName("M_Login");
		} else {
			mav.setViewName("M_Join");
		}

		return mav;
	}

	// 로그인
	public ModelAndView mLogin(MEMBER member) {

		System.out.println("[2] controller > service 변수 : " + member);
		// DB에서 가져온 암호화 값을 가져온다.
		String encPw = mdao.mLogin(member);

		if (pwEnc.matches(member.getMemPw(), encPw)) {
			MEMBER memInfo = mdao.mInfo(member);
			System.out.println("회원정보:" + memInfo);
			session.setAttribute("memInfo", memInfo);

			mav.setViewName("redirect:/bList");
			// 게시글 출력
		} else {
			mav.setViewName("M_Login");
		}
		System.out.println("[4] service < dao 변수 : " + member);

		return mav;
	}

//	public ModelAndView emailCheck(MEMBER member, String memKey) {
//		if(memKey.equals("1234")) {
//			System.out.println("이메일 인증 확인");
//		}
//		
//		int result = mdao.emailCheck(member);
//		
//		if(result > 0) {
//			mav.setViewName("loginForm");
//		} else {
//			mav.setViewName("index");
//		}
//		
//		return mav;
//	}
//
//	public ModelAndView mList() {
//
//		System.out.println("[2] controller > service 변수 : ");
//		List<Member> memberList = mdao.mList();
//		System.out.println("[4] service < dao 변수 : " + memberList);
//
//		mav.setViewName("M_List");
//		mav.addObject("memberList", memberList);
//
//		return mav;
//	}
	// 페이징
	public ModelAndView mList(int page) {

		// 페이지번호 갯수
		int block = 5;

		// 회원목록 갯수
		int limit = 10;

		// 전체회원수
		int mCount = mdao.mCount();

		int maxPage = (int) (Math.ceil((double) mCount / limit));

		// 현재 페이지가 maxPage보다 클경우 현재 페이지를 maxPage의 값으로 대체
		if (page > maxPage) {
			page = maxPage;
		}

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
		int endPage = startPage + block - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PAGE paging = new PAGE();

		paging.setPage(page);
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setLimit(limit);

		List<MEMBER> memberList = mdao.mList(paging);

		mav.addObject("memberList", memberList);
		mav.addObject("paging", paging);

		mav.setViewName("M_List");

		return mav;
	}

	// 회원검색
	public ModelAndView mSearch(SEARCH search) {

		List<MEMBER> memberList = mdao.mSearch(search);

		mav.addObject("memberList", memberList);
		mav.setViewName("M_List");

		return mav;
	}

	// 상세보기
	public ModelAndView mView(String memId) {
		MEMBER member = mdao.mView(memId);

		mav.addObject("memberList", member);
		mav.setViewName("M_View");
		System.out.println("[4] service < dao 변수 : " + memId);

		return mav;
	}

	// 회원수정페이지
	public ModelAndView mModifyForm(String memId) {
		MEMBER member = mdao.mView(memId);

		mav.addObject("member", member);
		mav.setViewName("M_ModifyForm");

		return mav;
	}

	// 회원수정
	public ModelAndView mModify(MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[2] controller > service 변수 : " + member);
		MultipartFile memProfile = member.getMemProfile();

		UUID uuid = UUID.randomUUID();

		String ProfileName = uuid.toString().substring(0, 8) + "_" + memProfile.getOriginalFilename();

		// String savePath =
		// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
		String savePath = request.getSession().getServletContext().getRealPath("/resources/profile/");
		// 만약에 업로드 파일이 있다면
		if (memProfile != null) {
			// 기존 파일 삭제
			String deletePath = request.getSession().getServletContext().getRealPath("/resources/profile/");
			member.getMemProfileName();
			File deleteFile = new File(deletePath);

			if (deleteFile.exists()) {
				deleteFile.delete();
				System.out.println("기존파일 삭제 성공");
			} else {
				System.out.println("기존파일 삭제 실패");
			}

			member.setMemProfileName(ProfileName);
			memProfile.transferTo(new File(savePath + ProfileName));
		}

		String addr1 = member.getAddr1();
		String addr2 = member.getAddr2();
		String addr3 = member.getAddr3();

		String memAddr = "(" + addr1 + ") " + addr2 + ", " + addr3;
		member.setMemAddr(memAddr);

		// 수정
		int result = mdao.mModify(member);
		System.out.println("[4] service < dao 변수 : " + member);

		if (result > 0) {
			MEMBER memInfo = mdao.mInfo(member);
			System.out.println("회원정보:" + memInfo);
			session.setAttribute("memInfo", memInfo);

			mav.setViewName("M_profile");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	public ModelAndView mDelete(String memId) {

		int result = mdao.mDelete(memId);

		if (result > 0) {
			session.invalidate();
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	// 아이디 중복체크 ajax
	public String idoverlap(String memId) {

		String CheckId = mdao.CheckId(memId);
		String result;

		if (CheckId == null) {
			// 아아디 사용가능
			result = "OK";
		} else {
			// 이미 사용중인 아이디
			result = "NO";
		}
		return result;
	}

	public String mCheckEmail(String memEmail) {
		System.out.println("이메일 주소 : " + memEmail);
		String uuid = UUID.randomUUID().toString().substring(0, 6);

		MimeMessage mail = mailSender.createMimeMessage();

		String mailContent = "<h2>안녕하세요. 인천일보 아카데미입니다.</h2><br/>" + "<h3>인증번호는 " + uuid + " 입니다.</h3>";

		try {
			mail.setSubject("[이메일 인증] 인천일보 아카데미 이메일 인증", "UTF-8");
			mail.setText(mailContent, "UTF-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(memEmail));

			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return uuid;
	}

	// 비밀번호 변경
	public ModelAndView mChangePw(MEMBER member) {

		// 비밀번호 암호화
		member.setMemPw(pwEnc.encode(member.getMemPw()));
		
		System.out.println("비밀번호 변경 :" +member);
		int result = mdao.mChangePw(member);
		
		if(result>0) {
			mav.setViewName("redirect:/bList");
		}else {
			mav.setViewName("M_profile");
		}
		System.out.println("dao통과");

		return mav;
	}

}
