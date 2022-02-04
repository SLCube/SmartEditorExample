package com.smarteditor.example.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.smarteditor.example.board.dto.BoardDTO;

@SpringBootTest
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;

	@Test
	void testByInsertBoard() {
		int num = 0;
		for (int i = 0; i < 20; i++) {
			BoardDTO params = new BoardDTO();
			params.setContent("mapperTest content");

			boardMapper.insertBoard(params);
			num++;
		}
		System.out.println("성공 횟수 : " + num);
	}

	@Test
	void testByGetBoardDetail() {
		BoardDTO board = boardMapper.getBoardDetail((long) 1);

		System.out.println(board.getBoardSeq());
		System.out.println(board.getContent());
		System.out.println(board.getInsertTime());
		System.out.println(board.getUpdateTime());
		System.out.println(board.getDeleteTime());
		System.out.println(board.getDeleteYn());

	}

	@Test
	void testByGetBoardList() {
		int boardTotalCount = boardMapper.getBoardTotalCount();

		if (boardTotalCount > 0) {
			List<BoardDTO> boardList = boardMapper.getBoardList();
			if (CollectionUtils.isEmpty(boardList) == false) {
				for (int i = 0; i < boardList.size(); i++) {
					System.out.println("=======================================");
					System.out.println(boardList.get(i).getBoardSeq());
					System.out.println(boardList.get(i).getContent());
					System.out.println(boardList.get(i).getInsertTime());
					System.out.println(boardList.get(i).getUpdateTime());
					System.out.println(boardList.get(i).getDeleteTime());
					System.out.println(boardList.get(i).getDeleteYn());
				}
			}
		}
	}

	@Test
	void testByUpdateBoard() {
		BoardDTO params = new BoardDTO();
		params.setContent("1번게시글 수정 내용");
		params.setBoardSeq((long) 1);

		int result = boardMapper.updateBoard(params);

		if (result == 1) {
			BoardDTO board = boardMapper.getBoardDetail((long) 1);
			System.out.println(board.getBoardSeq());
			System.out.println(board.getContent());
			System.out.println(board.getInsertTime());
			System.out.println(board.getUpdateTime());
			System.out.println(board.getDeleteTime());
			System.out.println(board.getDeleteYn());
		}
	}

	@Test
	void testByDeleteBoard() {
		int result = boardMapper.deleteBoard((long) 1);

		System.out.println("결과는 : " + result);
	}

}
