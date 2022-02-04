package com.smarteditor.example.board.dto;

import com.smarteditor.example.common.dto.CommonDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO extends CommonDTO {

	private Long boardSeq;
	
	private String title;
	
	private String content;
	
}
