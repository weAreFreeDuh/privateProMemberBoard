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

	// 게시글 작성을 위한 작성자 가져오기
	public ModelAndView bWriteForm(String memId) {

		String result = bdao.bWriteForm(memId);

		if (result == null) {
			// 값이 없을경우
			mav.setViewName("index");
		} else {
			// 값이 있을겨우
			mav.addObject("result", result);
			mav.setViewName("B_WriteForm");
		}
		return mav;
	}

	// 게시글 작성
	public ModelAndView bWrite(BOARD board) throws IllegalStateException, IOException {

		System.out.println("[2] controller > service 변수 : " + board);

		// 업로드 파일 이름
		MultipartFile boFile = board.getBoFile();

		UUID uuid = UUID.randomUUID();

		if (boFile != null) {

			String boFileName = uuid.toString().substring(0, 8) + "_" + boFile.getOriginalFilename();

			board.setBoFileName(boFileName);

			// 저장 경로(절대 경로)에 파일을 업로드한다.
			// String savePath =
			// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
			// 상대 경로로 서버에 업로드
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
		// 페이지번호 갯수
		int block = 5;

		// 회원목록 갯수
		int limit = 5;

		// 전체게시글 수
		int mCount = bdao.bCount();

		int maxPage = (int) (Math.ceil((double) mCount / limit));

		// 현재 페이지가 maxPage보다 클경우 현재 페이지를 maxPage의 값으로 대체
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
	
	// 게시글 검색기능
	public ModelAndView bSearch(SEARCH search) {
		
		List<BOARD> boardList = bdao.bSearch(search);
		
		mav.addObject("boardList",boardList);
		mav.setViewName("index");
		return mav;
	}
	// 게시글 상세보기
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
		System.out.println("[2] controller > service 변수 : " + board);

		// 업로드 파일 이름
		MultipartFile boFile = board.getBoFile();

		UUID uuid = UUID.randomUUID();

		if (boFile != null) {

			String boFileName = uuid.toString().substring(0, 8) + "_" + boFile.getOriginalFilename();

			board.setBoFileName(boFileName);

			// 저장 경로(절대 경로)에 파일을 업로드한다.
			// String savePath =
			// "C:\\Users\\user\\Desktop\\3.9Sping\\MEMBOARD\\src\\main\\webapp\\resources\\profile\\";
			// 상대 경로로 서버에 업로드
			String savePath = request.getServletContext().getRealPath("/resources/fileUpload/");

			boFile.transferTo(new File(savePath + boFileName));
		}

		int result = bdao.bModify(board);
		System.out.println("[2] controller > service 변수 : " + result);

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
