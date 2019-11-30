package com.example.demo.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpInfoDto {
	private String empNo;
	private String empNm;
	private String deptCd;
	private String deptNm;
	private String gender;
	private String retireDt;
	private String regUserId;
	private Date   regDttm;
	private String lastModUserId;
	private Date   lastModDttm;
	private String jobId;
}
