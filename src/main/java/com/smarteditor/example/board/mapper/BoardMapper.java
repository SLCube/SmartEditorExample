package com.smarteditor.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smarteditor.example.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	public int insertBoard(BoardDTO params);
	
	public BoardDTO selectBoardDetail(Long boardSeq);
	
	public List<BoardDTO> selectBoardList();
	
	public int updateBoard(BoardDTO params);
	
	public int deleteBoard(Long boardSeq);
	
	public int selectBoardTotalCount();
	
}
