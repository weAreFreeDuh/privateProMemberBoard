package com.icia.pro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class COMMENT {
	private int cmtNum; // ��۹�ȣ
	private int cbNum; // �Խñ۹�ȣ
	private String cmtWriter; // ����ۼ���
	private String cmtContent; // ��� ����
	private Date cmtDate; // ��� �ۼ���
}
