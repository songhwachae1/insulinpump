package com.songhwa.insulin.dto;

import lombok.Data;

@Data
public class Record {
	private Long id;
	private String userEmail;
	private int glucoseLevel;
	private String measureDate;
}
