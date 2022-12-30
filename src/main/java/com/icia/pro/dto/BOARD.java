package com.icia.pro.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BOARD {

	private int boNum; // �Խñ� ��ȣ
	private String boWriter; // �Խñ� �ۼ���
	private String boTitle; // �� ����
	private String boContent; // �۳���
	private String boDate; // �ۼ���
	private int boHit; // ��ȸ��

	private MultipartFile boFile; // ���ε� ����
	private String boFileName; // ���� �̸�
}

