package com.icia.pro.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BOARD {

	private int boNum; // 게시글 번호
	private String boWriter; // 게시글 작성자
	private String boTitle; // 글 제목
	private String boContent; // 글내용
	private String boDate; // 작성일
	private int boHit; // 조회수

	private MultipartFile boFile; // 업로드 파일
	private String boFileName; // 파일 이름
}

