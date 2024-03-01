package com.songhwa.insulin.dto;

import lombok.Data;

@Data
public class Record {
	private Long id;
	private Long userId;
	private int glucoseLevel;
	private String measureDate;
}
