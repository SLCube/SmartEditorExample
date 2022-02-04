package com.smarteditor.example.common.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDTO {

	private LocalDateTime insertTime;
	
	private LocalDateTime updateTime;
	
	private LocalDateTime deleteTime;
	
	private String deleteYn;
}
