package com.icia.pro.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MEMBER {

	private String memId; // ȸ�����̵�
	private String memPw; // ��й�ȣ
	private String memName; // �̸�
	private String memBirth; // ����
//	private String memGender; // ����
	private String memEmail; // �̸���
	private String memPhone; // ��ȭ��ȣ
	private String memAddr; // �ּ� 

	private MultipartFile memProfile; // ���ε� ����
	private String memProfileName; // ���ε� �����̸�

	private String addr1; // �����ȣ
	private String addr2; // �ּ�
	private String addr3; // ���ּ�
	

}
