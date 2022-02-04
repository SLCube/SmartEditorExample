package com.smarteditor.example.board.mapper;

import java.util.List;

import com.smarteditor.example.board.dto.AttachDTO;

public interface AttachMapper {
	
	public int insertImg(AttachDTO params);
	
	public AttachDTO selectImgDetail(Long imgSeq);
	
	public int deleteImg(Long imgSeq);
	
	public List<AttachDTO> selectImgList(Long boardSeq);
	
	public int selectImgTotalCount(Long boardSeq);
	
}
