package com.icia.pro.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class COMMENT {
	private int cmtNum; // ´ñ±Û¹øÈ£
	private int cbNum; // °Ô½Ã±Û¹øÈ£
	private String cmtWriter; // ´ñ±ÛÀÛ¼ºÀÚ
	private String cmtContent; // ´ñ±Û ³»¿ë
	private Date cmtDate; // ´ñ±Û ÀÛ¼ºÀÏ
}
