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

	private final static String mSalt = "�ڽ�";

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

	// ���̵� �ߺ�Ȯ��
	public ModelAndView CheckId(String memId) {

		System.out.println("[2] controller > service ���� : " + memId);
		String CheckId = mdao.CheckId(memId);
		System.out.println("[4] service < dao ���� : " + CheckId);
		if (CheckId == null) {
			// �ƾƵ� ��밡��
			mav.setViewName("M_Join1");
			mav.addObject("CheckId", memId);
		} else {
			// �̹� ������� ���̵�
			mav.setViewName("M_Join2");
			mav.addObject("CheckId", memId);
		}

		return mav;
	}

	// ȸ������
	public ModelAndView mJoin(MEMBER member) throws IllegalStateException, IOException {

		// ��ȣȭ
//		String Sha = encodeSha256(member.getMemPw()).substring(0, 16)
//				+ encodeSha256(member.getMemId()).substring(0, 16);
//		member.setMemPw(Sha);
//		System.out.println("��й�ȣ ��ȣȭ : " + member.getMemPw());

		// [1] ���� ���ε�
		// - ���� �̸� ����
		// - (�ĺ��� uuid + �����̸�)
		// - profile���� ���� �� ���ε�
		// (1) �������� ��������
		System.out.println("[2] controller > service ���� : " + member);
		MultipartFile memProfile = member.getMemProfile();

		// (2) �����̸� �����ϱ�
		UUID uuid = UUID.randomUUID();

		System.out.println("uuid Ȯ�� : " + uuid.toString().substring(0, 8));

		// ���࿡ ���ε� ������ ���ٸ�
		if (memProfile != null) {

			// ������ �ĺ����� uuid.toString().subString(0,8)�� ���� �����̸��� ��ģ ��
			String memProfileName = uuid.toString().substring(0, 8) + "_" + memProfile.getOriginalFilename();

			// member ��ü�� ������ �����̸��� ���ε��� ���� �̸��� �����Ѵ�
			member.setMemProfileName(memProfileName);

			// ���� ���(���� ���)�� ������ ���ε��Ѵ�.
			// String savePath =
			// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
			// ��� ��η� ������ ���ε�
			String savePath = request.getSession().getServletContext().getRealPath("/resources/profile/");

			memProfile.transferTo(new File(savePath + memProfileName));
		}

		// [2] �ּ� ����
		// - (addr1) + addr2 + addr3
		// ex) (22223) ��õ ����Ȧ�� �ż�Ȧ�� 488���� 6-32, �½º��� 4�� // �� ���� ���
		// - setter ����ؼ� memAddr�� �����ϱ�
		String addr1 = member.getAddr1();
		String addr2 = member.getAddr2();
		String addr3 = member.getAddr3();

		String memAddr = "(" + addr1 + ") " + addr2 + ", " + addr3;
		member.setMemAddr(memAddr);

		// ��й�ȣ ��ȣȭ
		member.setMemPw(pwEnc.encode(member.getMemPw()));

		// ����
		System.out.println("[4] service < dao ���� : " + member);
		int result = mdao.mJoin(member);

		if (result > 0) {
			mav.setViewName("M_Login");
		} else {
			mav.setViewName("M_Join");
		}

		return mav;
	}

	// �α���
	public ModelAndView mLogin(MEMBER member) {

		System.out.println("[2] controller > service ���� : " + member);
		// DB���� ������ ��ȣȭ ���� �����´�.
		String encPw = mdao.mLogin(member);

		if (pwEnc.matches(member.getMemPw(), encPw)) {
			MEMBER memInfo = mdao.mInfo(member);
			System.out.println("ȸ������:" + memInfo);
			session.setAttribute("memInfo", memInfo);

			mav.setViewName("redirect:/bList");
			// �Խñ� ���
		} else {
			mav.setViewName("M_Login");
		}
		System.out.println("[4] service < dao ���� : " + member);

		return mav;
	}

//	public ModelAndView emailCheck(MEMBER member, String memKey) {
//		if(memKey.equals("1234")) {
//			System.out.println("�̸��� ���� Ȯ��");
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
//		System.out.println("[2] controller > service ���� : ");
//		List<Member> memberList = mdao.mList();
//		System.out.println("[4] service < dao ���� : " + memberList);
//
//		mav.setViewName("M_List");
//		mav.addObject("memberList", memberList);
//
//		return mav;
//	}
	// ����¡
	public ModelAndView mList(int page) {

		// ��������ȣ ����
		int block = 5;

		// ȸ����� ����
		int limit = 10;

		// ��üȸ����
		int mCount = mdao.mCount();

		int maxPage = (int) (Math.ceil((double) mCount / limit));

		// ���� �������� maxPage���� Ŭ��� ���� �������� maxPage�� ������ ��ü
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

	// ȸ���˻�
	public ModelAndView mSearch(SEARCH search) {

		List<MEMBER> memberList = mdao.mSearch(search);

		mav.addObject("memberList", memberList);
		mav.setViewName("M_List");

		return mav;
	}

	// �󼼺���
	public ModelAndView mView(String memId) {
		MEMBER member = mdao.mView(memId);

		mav.addObject("memberList", member);
		mav.setViewName("M_View");
		System.out.println("[4] service < dao ���� : " + memId);

		return mav;
	}

	// ȸ������������
	public ModelAndView mModifyForm(String memId) {
		MEMBER member = mdao.mView(memId);

		mav.addObject("member", member);
		mav.setViewName("M_ModifyForm");

		return mav;
	}

	// ȸ������
	public ModelAndView mModify(MEMBER member) throws IllegalStateException, IOException {

		System.out.println("[2] controller > service ���� : " + member);
		MultipartFile memProfile = member.getMemProfile();

		UUID uuid = UUID.randomUUID();

		String ProfileName = uuid.toString().substring(0, 8) + "_" + memProfile.getOriginalFilename();

		// String savePath =
		// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
		String savePath = request.getSession().getServletContext().getRealPath("/resources/profile/");
		// ���࿡ ���ε� ������ �ִٸ�
		if (memProfile != null) {
			// ���� ���� ����
			String deletePath = request.getSession().getServletContext().getRealPath("/resources/profile/");
			member.getMemProfileName();
			File deleteFile = new File(deletePath);

			if (deleteFile.exists()) {
				deleteFile.delete();
				System.out.println("�������� ���� ����");
			} else {
				System.out.println("�������� ���� ����");
			}

			member.setMemProfileName(ProfileName);
			memProfile.transferTo(new File(savePath + ProfileName));
		}

		String addr1 = member.getAddr1();
		String addr2 = member.getAddr2();
		String addr3 = member.getAddr3();

		String memAddr = "(" + addr1 + ") " + addr2 + ", " + addr3;
		member.setMemAddr(memAddr);

		// ����
		int result = mdao.mModify(member);
		System.out.println("[4] service < dao ���� : " + member);

		if (result > 0) {
			MEMBER memInfo = mdao.mInfo(member);
			System.out.println("ȸ������:" + memInfo);
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

	// ���̵� �ߺ�üũ ajax
	public String idoverlap(String memId) {

		String CheckId = mdao.CheckId(memId);
		String result;

		if (CheckId == null) {
			// �ƾƵ� ��밡��
			result = "OK";
		} else {
			// �̹� ������� ���̵�
			result = "NO";
		}
		return result;
	}

	public String mCheckEmail(String memEmail) {
		System.out.println("�̸��� �ּ� : " + memEmail);
		String uuid = UUID.randomUUID().toString().substring(0, 6);

		MimeMessage mail = mailSender.createMimeMessage();

		String mailContent = "<h2>�ȳ��ϼ���. ��õ�Ϻ� ��ī�����Դϴ�.</h2><br/>" + "<h3>������ȣ�� " + uuid + " �Դϴ�.</h3>";

		try {
			mail.setSubject("[�̸��� ����] ��õ�Ϻ� ��ī���� �̸��� ����", "UTF-8");
			mail.setText(mailContent, "UTF-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(memEmail));

			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return uuid;
	}

	// ��й�ȣ ����
	public ModelAndView mChangePw(MEMBER member) {

		// ��й�ȣ ��ȣȭ
		member.setMemPw(pwEnc.encode(member.getMemPw()));
		
		System.out.println("��й�ȣ ���� :" +member);
		int result = mdao.mChangePw(member);
		
		if(result>0) {
			mav.setViewName("redirect:/bList");
		}else {
			mav.setViewName("M_profile");
		}
		System.out.println("dao���");

		return mav;
	}

}
