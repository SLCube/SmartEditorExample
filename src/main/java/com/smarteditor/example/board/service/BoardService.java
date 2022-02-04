package com.smarteditor.example.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smarteditor.example.board.dto.BoardDTO;
import com.smarteditor.example.board.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;

		if (params.getBoardSeq() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}
	
	public boolean registerBoard(BoardDTO params, MultipartFile[] files) {
		int queryResult = 1;
		
		// TODO => fileUtils 추가
		
		if(registerBoard(params) == false) {
			return false;
		}
		
		return false;
	}

	public BoardDTO getBoardDetail(Long boardSeq) {
		return boardMapper.selectBoardDetail(boardSeq);
	}

	public boolean deleteBoard(Long boardSeq) {
		int queryResult = 0;

		BoardDTO board = boardMapper.selectBoardDetail(boardSeq);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(boardSeq);
		}

		return (queryResult == 1) ? true : false;
	}

	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = Collections.emptyList();

		int boardTotalCount = boardMapper.selectBoardTotalCount();

		if (boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList();
		}
		return boardList;
	}

}
