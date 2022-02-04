package com.smarteditor.example.board.dto;

import com.smarteditor.example.common.dto.CommonDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachDTO extends CommonDTO {

	private Long imgSeq;
	
	private Long boardSeq;
	
	private String originalImgName;
	
	private String saveImgName;
	
	private int imgSize;
	
}
