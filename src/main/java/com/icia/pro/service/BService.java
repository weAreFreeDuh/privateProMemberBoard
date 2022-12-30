package com.icia.pro.service;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.pro.dao.BDAO;
import com.icia.pro.dto.BOARD;
import com.icia.pro.dto.PAGE;
import com.icia.pro.dto.SEARCH;

@Service
public class BService {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private BDAO bdao;

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private BCryptPasswordEncoder pwEnc;

	// �Խñ� �ۼ��� ���� �ۼ��� ��������
	public ModelAndView bWriteForm(String memId) {

		String result = bdao.bWriteForm(memId);

		if (result == null) {
			// ���� �������
			mav.setViewName("index");
		} else {
			// ���� �����ܿ�
			mav.addObject("result", result);
			mav.setViewName("B_WriteForm");
		}
		return mav;
	}

	// �Խñ� �ۼ�
	public ModelAndView bWrite(BOARD board) throws IllegalStateException, IOException {

		System.out.println("[2] controller > service ���� : " + board);

		// ���ε� ���� �̸�
		MultipartFile boFile = board.getBoFile();

		UUID uuid = UUID.randomUUID();

		if (boFile != null) {

			String boFileName = uuid.toString().substring(0, 8) + "_" + boFile.getOriginalFilename();

			board.setBoFileName(boFileName);

			// ���� ���(���� ���)�� ������ ���ε��Ѵ�.
			// String savePath =
			// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
			// ��� ��η� ������ ���ε�
			String savePath = request.getServletContext().getRealPath("/resources/fileUpload/");

			boFile.transferTo(new File(savePath + boFileName));
		}

		int result = bdao.bWrite(board);

		if (result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	public ModelAndView bList(int page) {
		// ��������ȣ ����
		int block = 5;

		// ȸ����� ����
		int limit = 5;

		// ��ü�Խñ� ��
		int mCount = bdao.bCount();

		int maxPage = (int) (Math.ceil((double) mCount / limit));

		// ���� �������� maxPage���� Ŭ��� ���� �������� maxPage�� ������ ��ü
		if (page > maxPage) {
			page = maxPage;
		}

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int startPage = (((int) (Math.ceil((double) page / block))) - 1) * block + 1;
		System.out.println("===========================================================");
		System.out.println(startPage);
		System.out.println((int) (Math.ceil((double) page / block)));
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

		List<BOARD> boardList = bdao.bList(paging);

		mav.addObject("boardList", boardList);
		mav.addObject("paging", paging);

		mav.setViewName("index");

		return mav;
	}
	
	// �Խñ� �˻����
	public ModelAndView bSearch(SEARCH search) {
		
		List<BOARD> boardList = bdao.bSearch(search);
		
		mav.addObject("boardList",boardList);
		mav.setViewName("index");
		return mav;
	}
	// �Խñ� �󼼺���
	public ModelAndView bView(BOARD board) {
		
		BOARD result = bdao.bView(board);
		
		System.out.println("board : "+ board);
		
		mav.addObject("board",result);
		mav.setViewName("B_View");
		
		return mav;
	}

	public ModelAndView bModifyForm(BOARD board) {
		
		BOARD result = bdao.bView(board);
		
		mav.addObject("board",result);
		mav.setViewName("B_ModifyForm");
		
		return mav;
	}

	public ModelAndView bModify(BOARD board) throws IllegalStateException, IOException {
		System.out.println("[2] controller > service ���� : " + board);

		// ���ε� ���� �̸�
		MultipartFile boFile = board.getBoFile();

		UUID uuid = UUID.randomUUID();

		if (boFile != null) {

			String boFileName = uuid.toString().substring(0, 8) + "_" + boFile.getOriginalFilename();

			board.setBoFileName(boFileName);

			// ���� ���(���� ���)�� ������ ���ε��Ѵ�.
			// String savePath =
			// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
			// ��� ��η� ������ ���ε�
			String savePath = request.getServletContext().getRealPath("/resources/fileUpload/");

			boFile.transferTo(new File(savePath + boFileName));
		}

		int result = bdao.bModify(board);
		System.out.println("[2] controller > service ���� : " + result);

		if (result > 0) {
			mav.setViewName("redirect:/bView?boNum="+board.getBoNum());
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	public ModelAndView bDelete(int boNum) {
		int result = bdao.bDelete(boNum);
		
		if(result>0) {
			mav.setViewName("redirect:/bList");
		}else {
			mav.setViewName("index");
		}
		
		return mav;
	}

}
