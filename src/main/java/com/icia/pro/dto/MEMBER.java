package com.icia.pro.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MEMBER {

	private String memId; // 회원아이디
	private String memPw; // 비밀번호
	private String memName; // 이름
	private String memBirth; // 생일
//	private String memGender; // 성별
	private String memEmail; // 이메일
	private String memPhone; // 전화번호
	private String memAddr; // 주소 

	private MultipartFile memProfile; // 업로드 파일
	private String memProfileName; // 업로드 파일이름

	private String addr1; // 우편번호
	private String addr2; // 주소
	private String addr3; // 상세주소
	

}
